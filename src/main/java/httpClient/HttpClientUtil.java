/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2021-01-16 11:38
 */
package httpClient;

/**
 * @author LYH
 * @date 2021/01/16 11:38
 */

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.*;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

@Slf4j
public class HttpClientUtil {
    public static final String CONTENT_TYPE = "application/json";
    public static final int CONNTIMEOUT = 10000;
    public static final int READTIMEOUT = 10000;
    public static final String CHARSET = "UTF-8";
    private static HttpClient client = null;

    /**初始化httpClient**/
    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(128);
        cm.setDefaultMaxPerRoute(128);
        client = HttpClients.custom().setConnectionManager(cm).build();
    }


    /**
     * yijson方式发送一个 Post 请求, 使用指定的字符集编码.
     *
     * @param url
     * @param body        RequestBody
     * @param mimeType    例如 application/json
     * @param CHARSET     编码
     * @param CONNTIMEOUT 建立链接超时时间,毫秒.
     * @param READTIMEOUT 响应超时时间,毫秒.
     * @return ResponseBody, 使用指定的字符集编码.
     * @throws ConnectTimeoutException 建立链接超时异常
     * @throws SocketTimeoutException  响应超时
     * @throws Exception
     */
    public static String postJson(String url, String body, String mimeType,
                                  String CHARSET, Integer CONNTIMEOUT, Integer READTIMEOUT, Map<String, String> headers)
            throws Exception {
        log.info("发送HTTP(S) POST 请求：" + url + " | " + mimeType + " | " + CHARSET + " | " + CONNTIMEOUT + " | " + READTIMEOUT);
        HttpClient client = null;
        HttpResponse res = null;
        HttpPost post = new HttpPost(url);
        String result = "";
        try {
            if (StringUtils.isNotBlank(body)) {
                HttpEntity entity = new StringEntity(body, ContentType.create(
                        mimeType, CHARSET));
                post.setEntity(entity);
            }
            if (headers != null && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }
            // 设置参数
            RequestConfig.Builder customReqConf = RequestConfig.custom();
            if (CONNTIMEOUT != null) {
                customReqConf.setConnectTimeout(CONNTIMEOUT);
            }
            if (READTIMEOUT != null) {
                customReqConf.setSocketTimeout(READTIMEOUT);
            }

            post.setConfig(customReqConf.build());
            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(post);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtil.client;
                res = client.execute(post);
            }
            result = resultPotting(res, url);
        } catch (Exception e) {
            if (res != null) {
                log.error("HTTP(S) POST 请求，状态异常：{},url:{}", res.getStatusLine().getStatusCode(), url);
            } else {
                log.error("HTTP(S) POST 请求异常 url:{}", url);
            }
            throw e;
        } finally {
            post.releaseConnection();
            if (null != res) {
                EntityUtils.consumeQuietly(res.getEntity());
            }
            if (url.startsWith("https") && client != null
                    && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
        return result;
    }

    /**
     * 提交form表单
     *
     * @param url
     * @param params
     * @param CONNTIMEOUT
     * @param READTIMEOUT
     * @return
     * @throws ConnectTimeoutException
     * @throws SocketTimeoutException
     * @throws Exception
     */
    public static String[] postForm(String url, Map<String, String> params,
                                    Map<String, String> headers, String token, Integer CONNTIMEOUT,
                                    Integer READTIMEOUT) throws Exception {
        log.info("发送HTTP(S) POST 请求：" + url + " | " + CONNTIMEOUT + " | " + READTIMEOUT);
        HttpResponse res = null;
        HttpClient client = null;
        String[] result = new String[2];
        HttpPost post = new HttpPost(url);
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> formParams = new ArrayList<NameValuePair>();
                Set<Map.Entry<String, String>> entrySet = params.entrySet();
                for (Map.Entry<String, String> entry : entrySet) {
                    formParams.add(new BasicNameValuePair(entry.getKey(), entry
                            .getValue()));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
                        formParams, Consts.UTF_8);
                post.setEntity(entity);
            }
            if (headers != null && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }
            // 设置参数
            RequestConfig.Builder customReqConf = RequestConfig.custom();
            if (CONNTIMEOUT != null) {
                customReqConf.setConnectTimeout(CONNTIMEOUT);
            }
            if (READTIMEOUT != null) {
                customReqConf.setSocketTimeout(READTIMEOUT);
            }
            post.setConfig(customReqConf.build());

            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(post);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtil.client;
                res = client.execute(post);
            }
            if (res.getStatusLine().getStatusCode() == 200) {
                InputStream is = res.getEntity().getContent();
                if (is != null) {
                    result[0] = IOUtils.toString(is, CHARSET);
                }
                if (!StringUtils.isBlank(token)) {
                    if (null != res.getFirstHeader(token)) {
                        result[1] = res.getFirstHeader(token).getValue();
                    }
                }
            } else {
//                LogUtil.getAppLogger().info("HTTP(S) POSTFORM 请求，状态异常：" + res.getStatusLine().getStatusCode() + " | " + url);
                throw new RuntimeException("请求通信 [ " + url + "] 时遇到异常");
            }
        } catch (Exception e) {
            if (res != null) {
                log.error("HTTP(S) POSTFORM 请求，状态异常：" + res.getStatusLine().getStatusCode() + " | " + url);
                throw e;
            }
        } finally {
            post.releaseConnection();
            if (null != res) {
                EntityUtils.consumeQuietly(res.getEntity());
            }
            if (url.startsWith("https") && client != null
                    && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
        return result;
    }

    /**
     * 发送一个 GET 请求
     *
     * @param url
     * @param data    必须为JSon格式
     * @param CHARSET
     * @return
     * @throws Exception
     */
    public static String get(String url, String data, String CHARSET, String token, Map<String, String> headers) throws Exception {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        if (!StringUtils.isBlank(data)) {
            //paramsMap = CommonUtil.convertJsonToMap(data);
        }
        String httpUrl = getHttpGetUrl(url, paramsMap, CHARSET);
        return get(httpUrl, CHARSET, headers, null, null, token);
    }

    /**
     * @description:
     * @param: [url 请求url, data 请求数据, CHARSET 字符编码, token token值, headers 请求headers, response 返回值]
     * @return: void
     * @auther: wanhua.wang
     * @date: 2018/9/17 19:30
     */
    public static void getFile(String url, String data, String CHARSET, String token, Map<String, String> headers, HttpServletResponse response) throws Exception {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        if (!StringUtils.isBlank(data)) {
            //paramsMap = CommonUtil.convertJsonToMap(data);
        }
        String httpUrl = getHttpGetUrl(url, paramsMap, CHARSET);
        getWithDownload(httpUrl, headers, token, response);
    }

    /**
     * 获取GET请求url
     *
     * @param url
     * @param params
     * @param encode
     * @return
     */
    public static String getHttpGetUrl(String url, Map<String, Object> params, String encode) {
        StringBuffer buf = new StringBuffer(url);
        if (params != null) {
            // 地址增加?或者&
            String flag = (url.indexOf('?') == -1) ? "?" : "&";
            // 添加参数
            for (String name : params.keySet()) {
                buf.append(flag);
                buf.append(name);
                buf.append("=");
                try {
                    String param = String.valueOf(params.get(name));
                    if (param == null) {
                        param = "";
                    }
                    buf.append(URLEncoder.encode(param, encode));
                } catch (UnsupportedEncodingException e) {
                    log.error("获取GET请求url发生异常，参数url:{},params:{},encode:{}", url, JSON.toJSONString(params), encode, e);
                }
                flag = "&";
            }
        }
        return buf.toString();
    }

    /**
     * 发送一个 GET 请求
     *
     * @param url
     * @param CHARSET
     * @param CONNTIMEOUT 建立链接超时时间,毫秒.
     * @param READTIMEOUT 响应超时时间,毫秒.
     * @return
     * @throws ConnectTimeoutException 建立链接超时
     * @throws SocketTimeoutException  响应超时
     * @throws Exception
     */
    public static String get(String url, String CHARSET, Map<String, String> headers, Integer CONNTIMEOUT,
                             Integer READTIMEOUT, String token) throws Exception {
        log.info("发送HTTP(S) GET 请求：" + url + " | " + CHARSET + " | " + CONNTIMEOUT + " | " + READTIMEOUT);
        HttpClient client = null;
        HttpResponse res = null;
        HttpGet get = new HttpGet(url);
        String result = "";
        try {
            // 设置参数
            RequestConfig.Builder customReqConf = RequestConfig.custom();
            if (CONNTIMEOUT != null) {
                customReqConf.setConnectTimeout(CONNTIMEOUT);
            }
            if (READTIMEOUT != null) {
                customReqConf.setSocketTimeout(READTIMEOUT);
            }
            get.setConfig(customReqConf.build());

            if (headers != null && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    get.addHeader(entry.getKey(), entry.getValue());
                }
            }

            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(get);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtil.client;
                res = client.execute(get);
            }
            result = resultPotting(res, url);
        } catch (Exception e) {
            if (res != null) {
                log.error("HTTP(S) GET 请求，状态异常：" + res.getStatusLine().getStatusCode() + " | " + url);
                throw e;
            }
        } finally {
            get.releaseConnection();
            if (null != res) {
                EntityUtils.consumeQuietly(res.getEntity());
            }
            if (url.startsWith("https") && client != null
                    && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
        return result;
    }

    /**
     * @description:封装接口调用返回结果
     * @param: [res, token, url]
     * @return: java.lang.String[]
     * @auther: wanhua.wang
     * @date: 2018/8/15 17:48
     */
    private static String resultPotting(HttpResponse res, String url) throws Exception {
        String result = "";
        if (res.getStatusLine().getStatusCode() == 200) {
            result = IOUtils.toString(res.getEntity().getContent(), CHARSET);
        } else {
            log.info("HTTP(S) 请求，状态异常：" + res.getStatusLine().getStatusCode() + " | " + url);
            throw new Exception("连接错误");
        }
        return result;
    }

    /**
     * 用于解决javax.net.ssl.SSLException
     *
     * @return
     * @throws GeneralSecurityException
     */
    private static CloseableHttpClient createSSLInsecureClient() throws GeneralSecurityException {
        RequestConfig.Builder requestBuilder = RequestConfig.custom();
        requestBuilder = requestBuilder.setSocketTimeout(10000);
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }
            }, new SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            log.error("createSSLInsecureClient发生异常", e);
        } catch (KeyManagementException e) {
            log.error("createSSLInsecureClient发生异常", e);
        }
        CloseableHttpClient client = HttpClientBuilder.create().setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext)).setDefaultRequestConfig(requestBuilder.build()).setSSLHostnameVerifier(new DefaultHostnameVerifier()).build();
        return client;
    }

    /**
     * 发送下载文件的HTTP_POST请求
     *
     * @param reqURL  请求地址
     * @param "params 请求参数,无参数时传null即可
     * @return 应答Map有两个key, isSuccess--yes or
     * no,fullPath--isSuccess为yes时返回文件完整保存路径,failReason--
     * isSuccess为no时返回下载失败的原因
     * @see 1)该方法用来下载文件
     * @see 2)该方法会自动关闭连接,释放资源
     * @see 3)方法内设置了连接和读取超时(时间由本工具类全局变量限定),超时或发生其它异常将抛出RuntimeException
     * @see 4)请求参数含中文等特殊字符时,可直接传入本方法,方法内部会使用本工具类设置的全局DEFAULT_CHARSET对其转码
     * @see 5)该方法在解码响应报文时所采用的编码,取自响应消息头中的[Content-Type:text/html;
     * charset=GBK]的charset值
     * @see "若响应消息头中未指定Content-Type属性,则会使用HttpClient内部默认的ISO-8859-1
     * @see 6)下载的文件会保存在java.io.tmpdir环境变量指定的目录中
     * @see "CentOS6.5下是/tmp,CentOS6.5下的Tomcat中是/app/tomcat/temp,Win7下是C:\Users\
     * Jadyer\AppData\Local\Temp\
     * @see 7)下载的文件若比较大,可能导致程序假死或内存溢出,此时可考虑在本方法内部直接输出流
     */
    public static Map<String, String> postWithDownload(String reqURL, String reqData, String contentType, Map<String, String> headers, String token) {
        log.info("请求{}的报文为-->>{}", reqURL, reqData);
        Map<String, String> resultMap = new HashMap<String, String>();
        HttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, Integer.valueOf(1000 * 60));
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, Integer.valueOf(10000 * 60));
        // 创建TrustManager(),用于解决javax.net.ssl.SSLPeerUnverifiedException: peer
        // not authenticated
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        // 创建HostnameVerifier,用于解决javax.net.ssl.SSLException: hostname in
        // certificate didn't match: <123.125.97.66> != <123.125.97.241>
        X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier() {
            @Override
            public void verify(String host, SSLSocket ssl) throws IOException {
            }

            @Override
            public void verify(String host, X509Certificate cert) throws SSLException {
            }

            @Override
            public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
            }

            @Override
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
        };
        HttpEntity entity = null;
        try {
            // TLS1.0是SSL3.0的升级版(网上已有人发现SSL3.0的致命BUG了),它们使用的是相同的SSLContext
            SSLContext sslContext = SSLContext.getInstance(org.apache.http.conn.ssl.SSLSocketFactory.TLS);
            // 使用TrustManager来初始化该上下文,TrustManager只是被SSL的Socket所使用
            sslContext.init(null, new TrustManager[]{trustManager}, null);
            // 创建SSLSocketFactory
            org.apache.http.conn.ssl.SSLSocketFactory socketFactory = new org.apache.http.conn.ssl.SSLSocketFactory(sslContext, hostnameVerifier);
            // 通过SchemeRegistry将SSLSocketFactory注册到HttpClient上
            httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));
            HttpPost httpPost = new HttpPost(reqURL);

            if (StringUtils.isBlank(contentType)) {
                httpPost.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=" + CHARSET);
            } else {
                httpPost.setHeader(HTTP.CONTENT_TYPE, contentType);
            }
            if (headers != null && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }
            httpPost.setEntity(new StringEntity(null == reqData ? "" : reqData, CHARSET));

            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                entity = response.getEntity();
                resultMap = httpFileDownload(entity, response, token);
                log.info("请求{}得到应答<<--{}", reqURL, JSON.toJSONString(resultMap));
            } else {
                throw new RuntimeException("请求通信[" + reqURL + "]时遇到异常");
            }
            return resultMap;
        } catch (ConnectTimeoutException cte) {
            throw new RuntimeException("请求通信[" + reqURL + "]时连接超时", cte);
        } catch (SocketTimeoutException ste) {
            throw new RuntimeException("请求通信[" + reqURL + "]时读取超时", ste);
        } catch (Exception e) {
            throw new RuntimeException("请求通信[" + reqURL + "]时遇到异常", e);
        } finally {
            try {
                EntityUtils.consume(entity);
            } catch (IOException e) {
                log.error("请求通信[" + reqURL + "]时关闭远程应答文件流时发生异常,堆栈轨迹如下", e);
            }
            httpClient.getConnectionManager().shutdown();
        }
    }


    /**
     * 发送下载文件的HTTP_POST请求
     *
     * @param url     请求地址
     * @param "params 请求参数,无参数时传null即可
     * @return 应答Map有两个key, isSuccess--yes or
     * no,fullPath--isSuccess为yes时返回文件完整保存路径,failReason--
     * isSuccess为no时返回下载失败的原因
     * @see 1)该方法用来下载文件
     * @see 2)该方法会自动关闭连接,释放资源
     * @see 3)方法内设置了连接和读取超时(时间由本工具类全局变量限定),超时或发生其它异常将抛出RuntimeException
     * @see 4)请求参数含中文等特殊字符时,可直接传入本方法,方法内部会使用本工具类设置的全局DEFAULT_CHARSET对其转码
     * @see 5)该方法在解码响应报文时所采用的编码,取自响应消息头中的[Content-Type:text/html;
     * charset=GBK]的charset值
     * @see "若响应消息头中未指定Content-Type属性,则会使用HttpClient内部默认的ISO-8859-1
     * @see 6)下载的文件会保存在java.io.tmpdir环境变量指定的目录中
     * @see "CentOS6.5下是/tmp,CentOS6.5下的Tomcat中是/app/tomcat/temp,Win7下是C:\Users\
     * Jadyer\AppData\Local\Temp\
     * @see 7)下载的文件若比较大,可能导致程序假死或内存溢出,此时可考虑在本方法内部直接输出流
     */
    public static void getWithDownload(String url, Map<String, String> headers, String token, HttpServletResponse response) throws Exception {
        log.info("发送HTTP(S) GET 请求：" + url + " | " + CHARSET + " | " + CONNTIMEOUT + " | " + READTIMEOUT);
        HttpClient client = null;
        HttpResponse res = null;
        HttpGet get = new HttpGet(url);
        File tempFile = null;
        try {
            // 设置参数
            RequestConfig.Builder customReqConf = RequestConfig.custom();
            customReqConf.setConnectTimeout(CONNTIMEOUT);
            customReqConf.setSocketTimeout(READTIMEOUT);
            get.setConfig(customReqConf.build());

            if (headers != null && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    get.addHeader(entry.getKey(), entry.getValue());
                }
            }

            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(get);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtil.client;
                res = client.execute(get);
            }
            if (res.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = res.getEntity();
                Map<String, String> resultMap = httpFileDownload(entity, res, token);
                tempFile = new File(resultMap.get("fullPath"));
                byte[] bytes = toByteArray(tempFile);
                response.getOutputStream().write(bytes, 0, bytes.length);
                if (!StringUtils.isBlank(token)) {
                    if (null != res.getFirstHeader(token)) {
                        response.setHeader(token, res.getFirstHeader(token).getValue());//设置返回参数
                    }
                }
                log.info("请求{}得到应答<<--{}", url, JSON.toJSONString(resultMap));
            } else {
                throw new RuntimeException("请求通信[" + url + "]时遇到异常");
            }
        } catch (Exception e) {
            if (res != null) {
                log.error("HTTP(S) GET 请求，状态异常：" + res.getStatusLine().getStatusCode() + " | " + url);
            }
            throw e;
        } finally {
            if (tempFile != null) {
                tempFile.delete();
            }
            get.releaseConnection();
            if (null != res) {
                EntityUtils.consumeQuietly(res.getEntity());
            }
            if (url.startsWith("https") && client != null
                    && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
    }

    /**
     * @description: 将文件转换成字节流
     * @param: [file 文件对象]
     * @return: byte[]
     * @auther: wanhua.wang
     * @date: 2018/9/17 19:46
     */
    public static byte[] toByteArray(File file) throws IOException {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 4];
            int n = 0;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            return out.toByteArray();
        } finally {
            if (null != in) {
                in.close();
            }
            if (null != out) {
                out.close();
            }
        }
    }

    /**
     * 输入流转字节流
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 4];
            int n = 0;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            return out.toByteArray();
        } finally {
            if (null != in) {
                in.close();
            }
            if (null != out) {
                out.close();
            }
        }
    }

    /**
     * @description:文件下载功能封装
     * @param: [entity, response, token]
     * @return: java.util.Map<java.lang.String, java.lang.String>
     * @auther: wanhua.wang
     * @date: 2018/9/17 19:41
     */
    public static Map<String, String> httpFileDownload(HttpEntity entity, HttpResponse response, String token) throws IOException {

        Map<String, String> resultMap = new HashMap<String, String>();
        if (null != entity
                && (entity.getContentType().getValue()
                .startsWith(ContentType.APPLICATION_OCTET_STREAM.getMimeType()))
                || entity.getContentType().getValue().contains("image/jpeg")
                || entity.getContentType().getValue().contains("text/plain")) {
            // 文件下载成功
            String filename = null;
            for (Header header : response.getAllHeaders()) {
                if (header.toString().startsWith("Content-Disposition")) {
                    filename = header.toString().substring(header.toString().indexOf("filename=") + 10);
                    filename = filename.substring(0, filename.length() - 1);
                    break;
                }
            }
            if (StringUtils.isBlank(filename)) {
                Header contentHeader = response.getFirstHeader("Content-Disposition");
                if (null != contentHeader) {
                    HeaderElement[] values = contentHeader.getElements();
                    if (values.length == 1) {
                        NameValuePair param = values[0].getParameterByName("filename");
                        if (null != param) {
                            filename = param.getValue();
                        }
                    }
                }
            }
            if (StringUtils.isBlank(filename)) {
                filename = UUID.randomUUID().toString().replaceAll("-", "");
            }
            File _file = new File(System.getProperty("java.io.tmpdir") + "/" + filename);
            FileUtils.copyInputStreamToFile(entity.getContent(), _file);
            resultMap.put("isSuccess", "yes");
            resultMap.put("fullPath", _file.getCanonicalPath());
            if (!StringUtils.isBlank(token)) {
                if (null != response.getFirstHeader(token)) {
                    resultMap.put(token, response.getFirstHeader(token).getValue());
                }
            }
        } else {
            // 文件下载失败
            resultMap.put("isSuccess", "no");
            resultMap.put("failReason", EntityUtils.toString(entity, CHARSET));
        }
        return resultMap;
    }
}
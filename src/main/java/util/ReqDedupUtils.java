package util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * <p> 请求去重工具类
 *
 * @author 【LYH】（【罗玉华】luoyuhua@lingxing.com）
 * @date 2022/6/2 9:57
 */
public class ReqDedupUtils {
    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReqDedupUtils.class);

    /**
     * <p> 去除参数的MD5摘要
     *
     * @param reqJSON     请求的参数 这里通常是JSON
     * @param excludeKeys 请求参数里面要去除哪些字段再求摘要
     * @return java.lang.String
     * @author [LYH] ([罗玉华]luoyuhua@lingxing.com)
     * @date 2022/6/2 9:58
     */
    public String dedupParamMD5(final String reqJSON, String... excludeKeys) {

        TreeMap paramTreeMap = JSON.parseObject(reqJSON, TreeMap.class);
        if (!StringUtils.isAnyBlank(excludeKeys)) {
            List<String> dedupExcludeKeys = Arrays.asList(excludeKeys);
            if (!dedupExcludeKeys.isEmpty()) {
                for (String dedupExcludeKey : dedupExcludeKeys) {
                    paramTreeMap.remove(dedupExcludeKey);
                }
            }
        }
        // MD5理论上可能会重复，但是去重通常是短时间窗口内的去重（例如一秒），一个短时间内同一个用户同样的接口能拼出不同的参数导致一样的MD5几乎是不可能的。
        String paramTreeMapJSON = JSON.toJSONString(paramTreeMap);
        String md5deDupParam = jdkMD5(paramTreeMapJSON);
        LOGGER.info("md5deDupParam = {}, excludeKeys = {} paramTreeMapJSON={}", md5deDupParam, Arrays.deepToString(excludeKeys),
                paramTreeMapJSON);
        return md5deDupParam;
    }

    /**
     * <p> md5值算法
     *
     * @param src
     * @return java.lang.String
     * @author [LYH] ([罗玉华]luoyuhua@lingxing.com)
     * @date 2022/6/2 10:02
     */
    private static String jdkMD5(String src) {
        String res = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] mdBytes = messageDigest.digest(src.getBytes());
            res = DatatypeConverter.printHexBinary(mdBytes);
        } catch (Exception e) {
            LOGGER.error("计算MD5值出现异常", e);
        }
        return res;
    }

    public static void main(String[] args) {
        //两个请求一样，但是请求时间差一秒
        String req = "{\n" +
                "\"requestTime\" :\"20190101120001\",\n" +
                "\"requestValue\" :\"1000\",\n" +
                "\"requestKey\" :\"key\"\n" +
                "}";

        String req2 = "{\n" +
                "\"requestTime\" :\"20190101120002\",\n" +
                "\"requestValue\" :\"1000\",\n" +
                "\"requestKey\" :\"key\"\n" +
                "}";

        //全参数比对，所以两个参数MD5不同
        String dedupMD5 = new ReqDedupUtils().dedupParamMD5(req);
        String dedupMD52 = new ReqDedupUtils().dedupParamMD5(req2);
        System.out.println("req1MD5 = " + dedupMD5 + " , req2MD5=" + dedupMD52);

        //去除时间参数比对，MD5相同
        String dedupMD53 = new ReqDedupUtils().dedupParamMD5(req, "requestTime");
        String dedupMD54 = new ReqDedupUtils().dedupParamMD5(req2, "requestTime");
        System.out.println("req1MD5 = " + dedupMD53 + " , req2MD5=" + dedupMD54);
    }
}

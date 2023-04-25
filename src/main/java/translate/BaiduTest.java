package translate;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 【LYH】（【罗玉华】luoyuhua@lingxing.com）
 * @date 2023/03/14 11:45
 **/
public class BaiduTest {
    public static void main(String[] args) throws Exception {
        //待翻译的英文
        String source = "apple";
        //请求百度翻译url
        String url = "http://api.fanyi.baidu.com/api/trans/vip/translate";
        //组装请求参数
        Map<String, Object> params = buildParams(source, "en", "ch");
        //发送post请求
        String response = HttpUtil.post(url, params);
        //解析响应
        JSONObject jsonObject = JSONObject.parseObject(response);
        JSONArray trans_result = jsonObject.getJSONArray("trans_result");
        trans_result.stream().forEach(System.out::println);
    }

    private static Map<String, Object> buildParams(String query, String from, String to) {
        Map<String, Object> params = new HashMap<>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("appid", "20200422000426940");
        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);
        // 签名
        String src = "20200422000426940" + query + salt + "l2U7pWcd90LkGj3zsvND"; // 加密前的原文
        params.put("sign", MD5.create().digest(src));
        return params;
    }

}

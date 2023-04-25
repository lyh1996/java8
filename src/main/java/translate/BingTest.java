package translate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * @author 【LYH】（【罗玉华】luoyuhua@lingxing.com）
 * @date 2023/03/14 14:28
 **/
public class BingTest {

    public static void main(String[] args) throws IOException {
        HttpUrl url =
                new HttpUrl.Builder()
                        .scheme("https")
                        .host("api.cognitive.microsofttranslator.com")
                        .addPathSegment("/translate")
                        .addQueryParameter("api-version", "3.0")
                        .addQueryParameter("from", "zh_CN")
                        .addQueryParameter("to", "en")
                        .build();
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        String translate = "苹果";
        RequestBody body = RequestBody.create(mediaType, translate);
        Request request =
                new Request.Builder()
                        .url(url)
                        .post(body)
                        .addHeader("Ocp-Apim-Subscription-Key", "b680595f57bf49eca9f42b6845d8918d")
                        .addHeader("Ocp-Apim-Subscription-Region", "global")
                        .addHeader("Content-type", "application/json")
                        .build();
        // log.info("bing进行翻译，源语言{}，目标语言{}，待翻译内容：{}", from, to, contents);
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        String json = response.body().string();
        System.out.println(MessageFormat.format("接收到bing翻译参数返回：{0},翻译内容：{1}", response, json));
        JSONArray jsonArray = JSON.parseArray(json);

    }
}

package translate;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author 【LYH】（【罗玉华】luoyuhua@lingxing.com）
 * @date 2023/03/27 16:18
 **/
public class MicrosoftTest {

    String key = "<YOUR-KEY>";
    String endpoint = "https://<NAME-OF-YOUR-RESOURCE>.cognitiveservices.azure.com/translator/text/batch/v1.0";
    String url = endpoint + "/batches/{id}";
    OkHttpClient client = new OkHttpClient();

    public void get() throws IOException {
        Request request = new Request.Builder().url(
                url).method("DELETE", null).addHeader("Ocp-Apim-Subscription-Key", key).build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public static void main(String[] args) throws IOException {
        try {
            MicrosoftTest jobs = new MicrosoftTest();
            jobs.get();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

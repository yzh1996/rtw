package Client;

import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * @ClassName: HttpClientTest
 * @Author: yzh
 * @Description:
 * @Date: 2022/1/1 11:08
 * @Version: 1.0
 */
public class HttpClientTest {
    public static void main(String[] args) {
        String uri = "192.168.158.1";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost =  new HttpPost(uri);
        httpPost.setEntity();
        try {
            httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

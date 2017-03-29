package mySeleniumClient;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
	public HttpClient httpClient;

	public HttpUtils() {
		httpClient = HttpClients.createDefault();

	}

	public String postHttp(String url, String content) {
		HttpPost httpPost = new HttpPost(url);
		String requContent = "";
		try {
			httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
			StringEntity entity = new StringEntity(content, "UTF-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				requContent = EntityUtils.toString(httpResponse.getEntity());
				System.out.println(requContent);
			} else {
				System.out.println("请求失败");
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requContent;
	}

}

package mySeleniumClient;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BroGetUrl {

	public String urlJson(String url) {
		return String.format("{\"url\":\"%s\"}", url);
	}

	public void startGetUrl(String url, String getUrl, String sessionId) {
		HttpUtils httpUtils = new HttpUtils();
		url = String.format(url, ProcessUtils.port, sessionId);
		System.out.println(url);
		String reqContent = httpUtils.postHttp(url, urlJson(getUrl));
		JsonObject returnData = new JsonParser().parse(reqContent).getAsJsonObject();
		if (returnData.get("status").getAsInt() == 0) {
			System.out.println("请求成功");
		}
	}

}

package mySeleniumClient;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StartBro {
	
	private String content = "{\"desiredCapabilities\":{\"browserName\":\"chrome\",\"chromeOptions\":{\"args\":[],\"extensions\":[]},\"version\":\"\",\"platform\":\"ANY\"},\"requiredCapabilities\":{},\"capabilities\":{\"desiredCapabilities\":{\"browserName\":\"chrome\",\"chromeOptions\":{\"args\":[],\"extensions\":[]},\"version\":\"\",\"platform\":\"ANY\"},\"requiredCapabilities\":{},\"alwaysMatch\":{\"version\":\"\",\"platform\":\"ANY\"},\"firstMatch\":[{\"browserName\":\"chrome\",\"chromeOptions\":{\"args\":[],\"extensions\":[]}}]}}";
	public  String sessionId = "";

	public void start() {
		HttpUtils httpClient = new HttpUtils();
		String reqContent = httpClient.postHttp(String.format(URLUtils.startBro, ProcessUtils.port), content);
		JsonObject returnData = new JsonParser().parse(reqContent).getAsJsonObject();
		if (returnData.get("status").getAsInt() == 0) {
			System.out.println("连接浏览器成功");
			sessionId = returnData.get("sessionId").getAsString();
		} else {
			System.out.println("链接浏览器失败");
		}

	}



}

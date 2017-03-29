package mySeleniumClient;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SendValue {
	
	public String json(String id,String value) {
		return String.format("{\"id\":\"%s\",\"value\":[\"%s\"]}", id,value);
	}

	public void startGetUrl(String url, String value, String sessionId,String id) {
		HttpUtils httpUtils = new HttpUtils();
		url = String.format(url, ProcessUtils.port, sessionId,id);
		System.out.println(url);
		String reqContent = httpUtils.postHttp(url, json(id,value));
		JsonObject returnData = new JsonParser().parse(reqContent).getAsJsonObject();
		if (returnData.get("status").getAsInt() == 0) {
			System.out.println("请求成功");
		}
	}
	
	

}

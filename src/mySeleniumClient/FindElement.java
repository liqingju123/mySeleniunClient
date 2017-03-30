package mySeleniumClient;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FindElement {
	private String idName;

	public FindElement(String idName) {
		this.idName = idName;
	}

	public String idJson(String idName) {
		return String.format("{\"using\":\"id\",\"value\":\"%s\"}", idName);
	}

	public String startFind(String url, String sessionId) {
		HttpUtils httpUtils = new HttpUtils();
		String reqContent = httpUtils.postHttp(String.format(url, ProcessUtils.port, sessionId), idJson(idName));
		JsonObject returnData = new JsonParser().parse(reqContent).getAsJsonObject();
		if (returnData.get("status").getAsInt() == 0) {
			System.out.println("请求成功");
			return returnData.get("value").getAsJsonObject().get("ELEMENT").getAsString();
		}
		return null;
	}

}

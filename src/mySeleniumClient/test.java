package mySeleniumClient;

public class test {

	public static void main(String[] args) {
//		ProcessUtils.shell(null);
		StartBro startBro = new StartBro();
		startBro.start();
		System.out.println("=====启动成功====");
		BroGetUrl broGetUrl = new BroGetUrl();
		broGetUrl.startGetUrl(URLUtils.GETURL, "http://www.baidu.com", startBro.sessionId);
		System.out.println("=====打开浏览器====");
		FindEleById FindEleById = new FindEleById("kw");
		String elementId = FindEleById.startFind(URLUtils.FINDELE, startBro.sessionId);
		SendValue sendValue = new SendValue();
		sendValue.startGetUrl(URLUtils.SENDVALUE, "=====", startBro.sessionId, elementId);
	}

}

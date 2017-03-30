package mySeleniumClient;

public class Test {

	public static void main(String[] args) {
		
		//打开驱动
		ProcessUtils.shell(null);
		StartBrowse startBro = new StartBrowse();
		startBro.start();
		System.out.println("=====启动成功====");
		BrowseGetUrl broGetUrl = new BrowseGetUrl();
		broGetUrl.startGetUrl(URLUtils.GETURL, "http://www.baidu.com", startBro.sessionId);
		System.out.println("=====打开浏览器====");
		FindElement FindEleById = new FindElement("kw");
		String elementId = FindEleById.startFind(URLUtils.FINDELE, startBro.sessionId);
		SendValue sendValue = new SendValue();
		sendValue.startGetUrl(URLUtils.SENDVALUE, "=====", startBro.sessionId, elementId);
	}

}

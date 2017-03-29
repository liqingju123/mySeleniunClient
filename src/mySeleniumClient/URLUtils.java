package mySeleniumClient;

public interface URLUtils {
	//启动浏览器界面
	public final static String startBro ="http://localhost:%d/session";
	public final static String GETURL ="http://localhost:%d/session/%s/url";
	public final static String FINDELE ="http://localhost:%d/session/%s/element";
	public final static String SENDVALUE ="http://localhost:%d/session/%s/element/%s/value";
	

}

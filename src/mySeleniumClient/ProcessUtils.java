package mySeleniumClient;

import java.io.IOException;

public class ProcessUtils {
	public final static int port =45742;

	/**
	 * 启动 chromedriver path 驱动地址
	 * 
	 * @param path
	 */
	public static void shell(String path) {
		if (path == null) {
			try {
				// port 是端口号 理论上讲 应该自己去 测试一把 有没有被占用 然后再去使用
				Process process = Runtime.getRuntime().exec(String.format("/Users/imac/Downloads/chromedriver --port=%d",port));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}

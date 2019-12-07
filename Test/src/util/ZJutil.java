package util;
/**
 * 注解模拟
 * @author Administrator
 *
 */
public class ZJutil {
	
	private String zj;
	
	/**
	 * 寻找注解标志
	 * @param text
	 */
	public  void find(String text) {
		if(text.contains("@")) {
			zj = text.substring(text.indexOf("@") + 1, text.length());
		}
		parseZJ(zj);
	}
	
	 public void find(String text,Object object) {
		if(text.contains("@")) {
			zj = text.substring(text.indexOf("@"), text.length());
		}
		parseZJ(zj,object);
	}
	
	/**
	 * 解析注解
	 * @param zj
	 */
	public void parseZJ(String zj) {
		ZJImpl impl = new ZJImpl(zj);
	}
	
	public void parseZJ(String zj,Object object) {
		ZJImpl impl = new ZJImpl(zj,object);
	}
}

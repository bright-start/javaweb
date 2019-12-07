package com.it.servlet;

import java.lang.reflect.Method;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {

	public static void main(String[] args) throws Exception {
		//加载web.xml
		//创建SAXReader
		SAXReader reader = new SAXReader();
		Document doc = reader.read("src/web.xml");
		//获取根元素
		Element rootElement = doc.getRootElement();
		System.out.println(rootElement);
		System.out.println("--------------");
		List<Element> list = rootElement.elements("servlet");
		for (Element servEle : list) {
			Element classEle = servEle.element("servlet-class");
			System.out.println(classEle.getText());
			Class clazz = Class.forName(classEle.getText());
			Object obj = clazz.newInstance();
			
			Method m = clazz.getMethod("init");
			m.invoke(obj);
		}
	}

}

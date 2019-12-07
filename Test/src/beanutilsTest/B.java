package beanutilsTest;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class B extends A{

	public B(A a) {
		try {
			BeanUtils.copyProperties(this, a);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] getTexts() {
		return super.getText().split(" ");
	}
	
}

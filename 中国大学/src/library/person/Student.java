package library.person;

import library.lib.ILib;
import library.lib.impl.Lib;
/**
 * 模拟一个学生
 * @author Administrator
 *
 */
public class Student extends APerson{
	

	private String name;
	
	Student(){
		this.name="学生";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void recode() {
		System.out.print("student");
	}

	@Override
	public void borrowing() {
		// TODO 自动生成的方法存根
		ILib lib = new Lib();
		recode();
		System.out.print("--"+getName()+"--");
		lib.borrowing();
	}

	@Override
	public void returning() {
		// TODO 自动生成的方法存根
		ILib lib = new Lib();
		recode();
		System.out.print("--"+getName()+"--");
		lib.returning();
	}
}

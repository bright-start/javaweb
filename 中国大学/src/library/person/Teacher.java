package library.person;

import library.lib.ILib;
import library.lib.impl.Lib;

/**
 * 模拟一个老师
 * @author Administrator
 *
 */
public class Teacher extends APerson{
	
	private String name;
	
	
	Teacher(){
		this.name = "教师";
	} 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void recode() {
		System.out.print("teacher");
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

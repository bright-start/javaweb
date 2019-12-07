package library.person;

import library.lib.ILib;
/**
 * 模拟一个借书人
 * 老师和学生共用一个借书规则，借和还
 * @author Administrator
 *
 */
public abstract class APerson {

	public abstract void borrowing();
	public abstract void returning();
}

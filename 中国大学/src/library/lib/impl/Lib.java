package library.lib.impl;

import library.lib.ILib;
/**
 * 继承图书馆接口
 * 模拟图书馆内部简易操作
 * @author Administrator
 *
 */
public class Lib implements ILib{

	private final static int totalBooks = 100;
	private static int totalLendBooks = 0;
	
	//借书
	@Override
	public void borrowing() {
		// TODO 自动生成的方法存根
		if(totalLendBooks < totalBooks)
		totalLendBooks += 1;
		System.out.println("借书...");
	}
	
	//还书
	@Override
	public void returning() {
		// TODO 自动生成的方法存根
		if(totalLendBooks > 0)
			totalLendBooks -= 1;
		System.out.println("还书。。。");
	}
	
	//图书馆书籍总量
	@Override
	public int totalBooks() {
		// TODO 自动生成的方法存根
		return totalBooks;
	}

	//图书馆借出的书总量
	@Override
	public int totalLendBooks() {
		// TODO 自动生成的方法存根
		return totalLendBooks;
	}
	
}

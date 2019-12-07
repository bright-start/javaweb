package library.person;

import library.lib.ILib;
import library.lib.impl.Lib;

/**
 * 测试类
 * @author Administrator
 *
 */
public class Test {
	
	public static void main(String[] args) {
		ILib lib = new Lib();
		int recode = 0;	
		//循环20次用来模拟20次借还书场景
		do {
			//随机一个学生或者老师借还书场景
			int random = (int) (Math.random()*4);
			//只有借出过书，才可以进行还书操作
			if(lib.totalLendBooks() > 0) {
				if(random >= 0 && random <= 1){
					APerson person = new Student();
					person.returning();
				}
				if(random > 1 && random <= 2){
					APerson person = new Teacher();
					person.returning();
				}
			}
			//书籍没有被全部借完就可以继续借书
			if(lib.totalLendBooks() != lib.totalBooks()) {
				if(random > 2 && random <= 3) {
					APerson person = new Student();
					person.borrowing();
	
				}
				if(random > 3 && random <= 4){
					APerson person = new Teacher();
					person.borrowing();
				}
			}
			//书籍借完，不可继续借书
			if(lib.totalLendBooks() == lib.totalBooks()) {
				System.out.println("书籍已借完，请下次再来");
			}
			//记录每次操作完成后图书馆情况
			System.out.println("借出："+lib.totalLendBooks()+"本");
			System.out.println("图书馆藏书量："+lib.totalBooks()+"本");
			System.out.println("-----------------------------------------");
			recode++;
		}while(recode < 20);
	}
	
}

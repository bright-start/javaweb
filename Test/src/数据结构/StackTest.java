package 数据结构;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> staffs = new Stack<String>();
		staffs.push("a");
		staffs.push("b");
		staffs.push("c");
		staffs.push("d");
		/*while(!staffs.isEmpty()) {
			System.out.println(staffs.pop());
		}*/
		int i = staffs.search("a");
		System.out.println(i);
	}
}

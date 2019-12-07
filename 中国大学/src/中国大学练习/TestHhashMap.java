package 中国大学练习;

import java.util.HashMap;
import java.util.Scanner;

public class TestHhashMap {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Class c = new Class();
		Class d = new Class();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		for (int j = 0; j < 2; j++) {
			System.out.println("请输入科目和成绩：");
			String aa = input.nextLine();
			Integer bb = new Integer(input.nextLine());
			c.setScore(aa, bb);
		}
		System.out.println("请输入学生姓名：");
		String cc = input.nextLine();
		c.setStudent(cc, c.getScore());

		for (int j = 0; j < 2; j++) {
			System.out.println("请输入科目和成绩：");
			String aa = input.nextLine();
			Integer bb = new Integer(input.nextLine());
			d.setScore(aa, bb);
		}
		System.out.println("请输入学生姓名：");
		String dd = input.nextLine();
		c.setStudent(dd, d.getScore());

		System.out.println("----------------------------------------");
		System.out.println("名字查找");
		String str = input.nextLine();
		System.out.println("科目     成绩");
		for (String l : c.stu.keySet()) {
			if (l.equals(str)) {
				HashMap<String, Integer> h = c.stu.get(l);
				for (String k : h.keySet()) {
					System.out.println(l + " " + k + " " + h.get(k));
				}
			}
		}
		System.out.println("科目查找");
		str = input.nextLine();
		System.out.println("姓名     成绩");
		for (String l : c.stu.keySet()) {
			HashMap<String, Integer> h = c.stu.get(l);
			for (String k : h.keySet()) {
				if (k.equals(str)) {
					System.out.println(k + " " + l + " " + h.get(k));
				}
			}
		}

	}

}

class Class {
	HashMap<String, HashMap<String, Integer>> stu = new HashMap<String, HashMap<String, Integer>>();
	HashMap<String, Integer> score = new HashMap<String, Integer>();

	void setStudent(String name, HashMap<String, Integer> map) {
		stu.put(name, map);
	}

	void setScore(String object, Integer value) {
		score.put(object, value);
	}

	HashMap<String, Integer> getScore() {
		return score;
	}

	HashMap<String, Integer> QuaryName(String name) {
		return stu.get(name);
	}

	HashMap<String, Integer> QuaryObject(String object) {
		return score;
	}
}

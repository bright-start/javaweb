package jvm;

public class TestSub {
	private String a = "父类的属性值";
	public TestSub() {
		call();
	}
	public void call() {
		System.out.println("父类的call方法调用"+a);
	}
	static class TestSu extends TestSub{
		private String a = "子类的属性值";
		public void call() {
			System.out.println(a);
		}
	}
	public static void main(String[] args) {
		TestSub ts = new TestSu();
	}
}

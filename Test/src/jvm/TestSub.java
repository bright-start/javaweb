package jvm;

public class TestSub {
	private String a = "���������ֵ";
	public TestSub() {
		call();
	}
	public void call() {
		System.out.println("�����call��������"+a);
	}
	static class TestSu extends TestSub{
		private String a = "���������ֵ";
		public void call() {
			System.out.println(a);
		}
	}
	public static void main(String[] args) {
		TestSub ts = new TestSu();
	}
}

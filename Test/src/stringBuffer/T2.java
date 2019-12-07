package stringBuffer;

public class T2 {
	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.setN(4);
		System.out.println(t1);
		del(t1, 3);
	}

	private static void del(final T1 t1, int i) {
		t1.setN(t1.getN() + i);
		System.out.println(t1);
	}
}

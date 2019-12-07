package one;

public class Test2{
	public static void main(String[] args) {
		Integer inte = -2;
		String bin = new String();
		bin = inte.toBinaryString(-2);
		System.out.println(bin);
		System.out.println(inte.toBinaryString(inte >> 2));
		System.out.println(inte>>2);
		System.out.println(inte.toBinaryString(inte >>> 3));
		System.out.println(inte>>>3);
	}
}



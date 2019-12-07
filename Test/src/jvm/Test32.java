package jvm;

public class Test32 {
//	public static Test32  t1 = new Test32();
	{
		System.out.println("blockA");
	}
	static {
		System.out.println("blockB");
	}
	public static void main(String[] args) {
		Test32 t2 = new Test32();
	}
}

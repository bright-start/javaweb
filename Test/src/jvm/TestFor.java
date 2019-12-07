package jvm;

public class TestFor {
	static boolean out(char c) {
		System.out.print(c);
		return true;
	}
	public static void main(String[] args) {
		int i = 0;
		for(out('A');out('B') && (i < 2); out('C')) {
			i++;
			out('D');
		}
	}
}

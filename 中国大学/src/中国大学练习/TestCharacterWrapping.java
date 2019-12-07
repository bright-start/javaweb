package 中国大学练习;

public class TestCharacterWrapping {

	public static void main(String[] args) {
		char c='a';
		System.out.println(Character.isDigit('1'));
		System.out.println(Character.isLetter('a'));
		System.out.println(Character.isLetterOrDigit('s'));
		System.out.println(Character.MAX_VALUE);//?
		System.out.println(Character.MAX_HIGH_SURROGATE);//?
		System.out.println(Character.isLowerCase('w'));
		System.out.println(Character.isUpperCase('B'));
		System.out.println(Character.toLowerCase('W'));
		System.out.println(Character.toUpperCase('b'));

	}

}

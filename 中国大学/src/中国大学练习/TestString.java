package 中国大学练习;

import java.util.Scanner;

public class TestString {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		String str_1="  12ed4DX",str_2="abcd";
		//str_1=in.nextLine();
		//str_2=in.nextLine();
		System.out.println("str_1: "+str_1);
		System.out.println("str_2: "+str_2);
		char a[]=new char[100];
		a=str_1.toCharArray();//字符串转字符数组
		for(int i=0;i<str_1.length();i++)    
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		/************ 以下操作并不改变本来字符串的内容   *************/
		System.out.println(str_1.toLowerCase());//大写字母变小写字母
		System.out.println(str_1.toUpperCase());//小写字母变大写字母
		System.out.println(str_1.trim());//去空格
		System.out.println(str_2.compareTo(str_1));
		System.out.println("abcd".compareTo(str_2));
		System.out.println("ABCD".compareToIgnoreCase(str_2));//忽略大小写比较
		System.out.println(str_2.indexOf('c'));//寻找该字符在字符串中的位置
		System.out.println(str_2.replace('b', 'B'));//字符替代
		/************ 以上操作并不改变本来字符串的内容   *************/
	}
}

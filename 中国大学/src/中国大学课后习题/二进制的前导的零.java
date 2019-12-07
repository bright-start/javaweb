package 中国大学课后习题;

import java.util.Scanner;

public class 二进制的前导的零 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int input,count,temp;
		input=in.nextInt();
		temp=input;
		count=0;
		input=Math.abs(input);
		while(input!=0)
		{
			input=input/2;
			count++;
		}
		if(temp==0)
			System.out.println(32);
		else if(temp>0)
		{
			System.out.println(32-count);
		}
		else
		{
			System.out.println(0);
		}
		
	}
}

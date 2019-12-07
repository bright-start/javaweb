package 中国大学练习;

import java.util.Scanner;

public class JudgeParity {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in=new Scanner(System.in);
		int input;
		int count_odd=0,count_even=0;
		while(true)
		{
			input=in.nextInt();
			if(input==-1)
				break;
			if(input%2!=0)
			{
				count_odd++;
			}
			else
			{
				count_even++;
			}
		}
		System.out.println(count_odd+" "+count_even);
	}

}

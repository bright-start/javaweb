package 中国大学课后习题;

import java.util.Scanner;

public class FeatureCalculation 
{
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		boolean num_parity=true,digit_parity=true;
		int number,temp;
		int count=0,add_binary=0;
		int binary_value;
		@SuppressWarnings("resource")
		Scanner in= new Scanner (System.in);
		number=in.nextInt();
		while(number>0)
		{
			temp=number%10;
			number=(number-temp)/10;
			if(temp%2==0)
				num_parity=true;
			else
				num_parity=false;
			count++;
			if(count%2==0)
				digit_parity=true;
			else
				digit_parity=false;
			binary_value=(int)Math.pow(2, count-1);
			if(num_parity==digit_parity)
			{
				add_binary+=binary_value;
			}
		}
		System.out.println(add_binary);
	}

}

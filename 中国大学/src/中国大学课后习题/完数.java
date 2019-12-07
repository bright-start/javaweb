package 中国大学课后习题;

import java.util.Scanner;

public class 完数 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int start_num,end_num;
		int sum;
		boolean flag=false;
		start_num=in.nextInt();
		end_num=in.nextInt();
		for(int i=start_num;i<=end_num;i++)
		{
			sum=0;
			for(int j=1;j<i;j++)
			{
				if(i%j==0)
				{
					sum+=j;
				}
			}
			if(sum==i)
			{
				if(flag)
					System.out.print(" "+i);
				else
				{
					flag=true;
					System.out.print(i);
				}
			}
		}
		System.out.println();

	}

}

package 中国大学课后习题;

import java.util.Scanner;

public class 分解质因数 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int num,k=0;
		boolean flag;
		int arr[]=new int[20000];
		num=in.nextInt();
		for(int i=2;i<20000;i++)
		{
			flag=true;
			for(int j=2;j<=Math.sqrt(i);j++)
			{
				if(i%j==0)
				{
					flag=false;
				}
			}
			if(flag)
			{
				arr[k]=i;
				k++;
			}
		}
		System.out.print(num+"=");
		while(num!=1)
		{
			for(int l=0;l<k;l++)
			{
				if(num%arr[l]==0)
				{
					if(num==arr[l])
					{
						num/=arr[l];
						System.out.println(arr[l]);
					}
					else
					{
						num/=arr[l];
						System.out.print(arr[l]+"x");
					}
					break;
				}
			}
		}
	}

}

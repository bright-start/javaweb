package 中国大学课后习题;

public class PrimeNumber
{
	public static void main(String[] args)
	{
		int i,j;
		boolean[] mark=new boolean[101];//申请一个满足所有数的数组
		for(i=2;i<=100;i++)
		{
			mark[i]=true;//记录该数是素数
		}
		for(i=2;i<=Math.sqrt(100);i++)//埃氏筛法
		{
			if(mark[i]==true)
			{
				for(j=i;j*i<=100;j++)//若该数不是素数则记为false
				{
					mark[i*j]=false;
				}
			}
		}
		int k=0;//记录每行输出的素数个数
		for(i=2;i<=100;i++)//输出数数
		{
			if(mark[i]==true)
			{
				k++;
				System.out.print(i+" ");
			}
			if(k==10)
			{
				k=0;
				System.out.println();
			}
		}
	}
}

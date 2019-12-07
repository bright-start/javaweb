package 中国大学课后习题;

import java.util.Scanner;

public class Prime {
	
	static int solve(int n,int m) {
		boolean isPrime;
		int sum=0,count=0;
		for(int i=2;i>=0;i++) {
			isPrime=true;
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j==0)
				{
					isPrime=false;
				}
			}
			if(isPrime)
			{
				count++;
				if(count>=n && count<=m)
					sum+=i;
				if(count>m)
					break;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		System.out.println(solve(n,m));
	}

}

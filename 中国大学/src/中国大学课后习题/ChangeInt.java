package 中国大学课后习题;

import java.util.Scanner;

public class ChangeInt {

	static void solve(int num) {
		int arr[]=new int[7];
		String s[]={"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
		int i=0;
		while(num>0)
		{
			arr[i]=num%10;
			num/=10;
			i++;
		}
		for(int j=i-1;j>=0;j--)
		{
			System.out.print(s[arr[j]]);
			if(j!=0)
				System.out.print(" ");	
		}
		
	}
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int intger;
		intger=in.nextInt();
		if(intger==0)
			System.out.print("ling");
		else
		{
			if(intger<0)
				System.out.print("fu ");
			solve(Math.abs(intger));
		}
	}
}

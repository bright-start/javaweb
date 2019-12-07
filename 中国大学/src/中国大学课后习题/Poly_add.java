package 中国大学课后习题;

import java.util.Scanner;

public class Poly_add {
	static void sort(int arr[][],int s)
	{
		for(int k=0;k<s;k++)
		{
			for(int l=k;l<=s;l++)
			{
				if(arr[k][0]<arr[l][0])
				{
					int t;
					t=arr[k][0];
					arr[k][0]=arr[l][0];
					arr[l][0]=t;
					t=arr[k][1];
					arr[k][1]=arr[l][1];
					arr[l][1]=t;
				}
			}
		}
	}
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int arr_1[][]=new int[50][2];
		int arr_2[][]=new int[50][2];
		int arr_3[][]=new int[100][2];
		int i=0,j=0,t=0;
		for(i=0;i>=0;i++)
		{
			arr_1[i][0]=in.nextInt();
			arr_1[i][1]=in.nextInt();
			if(arr_1[i][0]==0)
				break;
		}
		for(j=0;j>=0;j++)
		{
			arr_2[j][0]=in.nextInt();
			arr_2[j][1]=in.nextInt();
			if(arr_2[j][0]==0)
				break;
		}
		sort(arr_1,i);
		sort(arr_2,j);
		int m=0,n=0;
		while(m<=i && n<=j)
		{
				if(arr_1[m][0]==arr_2[n][0])
				{
					arr_3[t][0]=arr_1[m][0];
					arr_3[t][1]=arr_1[m][1]+arr_2[n][1];	
					m++;
					n++;
					t++;
				}
				else if(arr_1[m][0]>arr_2[n][0])
				{	
					arr_3[t][0]=arr_1[m][0];
					arr_3[t][1]=arr_1[m][1];
					m++;	
					t++;
				}
				else
				{
					arr_3[t][0]=arr_2[n][0];
					arr_3[t][1]=arr_2[n][1];
					n++;	
					t++;
				}
		}
		while(m<=i)
		{
			arr_3[t][0]=arr_1[m][0];
			arr_3[t][1]=arr_1[m][1];	
			t++;
			m++;
		}
		while(n<=j)
		{
			arr_3[t][0]=arr_2[n][0];
			arr_3[t][1]=arr_2[n][1];	
			t++;
			n++;
		}
		boolean flag=false;
		for(i=0;i<t;i++)
		{
			if(arr_3[i][1]>0 && flag==true)
				System.out.print("+");	
			if(arr_3[i][1]==0 && arr_3[i][0]!=0)
					continue;
			if(arr_3[i][0]==0)
			{
				System.out.print(arr_3[i][1]);
				continue;
			}	
			if(arr_3[i][0]==0 && arr_3[i][1]==0)
			{
				System.out.print("+0");
				flag=true;
				continue;
			}
			if(arr_3[i][0]==1 && arr_3[i][1]!=1 && arr_3[i][1]!=-1)
			{
				System.out.print(arr_3[i][1]+"x");
				flag=true;
				continue;
			}
			if(arr_3[i][0]==1 && arr_3[i][1]==1)
			{
				System.out.print("x");
				flag=true;
				continue;
			}
			if(arr_3[i][0]==1 && arr_3[i][1]==-1)
			{
				System.out.print("-x");
				flag=true;
				continue;
			}
			if(arr_3[i][1]==1 && arr_3[i][0]!=1 && arr_3[i][0]!=-1)
			{	
				System.out.print("x"+arr_3[i][0]);
				flag=true;
				continue;
			}
			if(arr_3[i][1]==-1 && arr_3[i][0]!=1 && arr_3[i][0]!=-1)
			{
				System.out.print("-x"+arr_3[i][0]);
				flag=true;
				continue;
			}
			if(arr_3[i][0]!=1 && arr_3[i][0]!=-1 && arr_3[j][1]!=1 && arr_3[i][1]!=1)
				System.out.print(arr_3[i][1]+"x"+arr_3[i][0]);
			flag=true;

		}
	}
}

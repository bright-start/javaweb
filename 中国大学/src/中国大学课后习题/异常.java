package 中国大学课后习题;

import java.util.Scanner;

public class 异常 {

	static void fun() throws CustomException
	{
		int a,b,res;
		Scanner in=new Scanner(System.in);
		a=in.nextInt();
		b=in.nextInt();
		if(b==0)
		{
			throw new CustomException();
		}
		res=a/b;
		System.out.println(a+"/"+b+"="+res);
	}
	public static void main(String[] args) {
		
		try
		{
			fun();
		}
		catch(CustomException e)
		{
			System.out.println("除数不能赋值为零！！！");
		}
	}

}
class CustomException extends Exception
{
	CustomException()
	{
		super();
	}
}

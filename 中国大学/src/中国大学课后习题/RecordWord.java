package 中国大学课后习题;

import java.util.Scanner;

public class RecordWord {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String str;
		str=in.nextLine();
		int temp=0;
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);

			if(ch=='.' && str.charAt(i-1)!=' ')
			{
				System.out.println(temp);
			}	
			if(ch=='.')
			{
				break;
			}
			if(ch!=' ')
			{
				temp++;
			}
			else if(str.charAt(i-1)!=' ')
			{
				System.out.print(temp+" ");
				temp=0;
			}
		}
	}

}

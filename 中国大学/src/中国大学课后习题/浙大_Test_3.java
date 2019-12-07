package 中国大学课后习题;

import java.util.Scanner;

public class 浙大_Test_3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String[] str = new String[100];
		int count = 0;
		while(true) {
			str[count]=in.next();
			if(str[count].equals("###"))
				break;
			count++;
		}
		//System.out.println(count);
		int[][] array=new int[count][count];
		int i,j;
		for(i = 0; i < count;i++) {
			for(j = 0; j < count; j++) {
				array[i][j] = in.nextInt();
			}
		}
		String start = new String();
		start = in.next();
		String end =  new String();
		end = in.next();
		int position_x = 0,position_y = 0;
		
		for(i = 0;i < count;i++) {
			if(str[i].equals(start))
			{
				position_x = i;
			}
			if(str[i].equals(end)) {
				position_y = i;
			}
		}
		System.out.println(array[position_x][position_y]);
	}

}

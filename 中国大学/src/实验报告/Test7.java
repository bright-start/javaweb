package 实验报告;

//求一个实数的平方
public class Test7 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		double in_num,square_num;
		in_num=Double.parseDouble(args[0]);
		square_num=Math.pow(in_num, 2);
		System.out.println(in_num+" 的平方数为："+square_num);		
	}

}

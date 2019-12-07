package 实验报告;

//求最大数
public class Test8 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a,b,c;
		a=Integer.parseInt(args[0]);
		b=Integer.parseInt(args[1]);
		c=Integer.parseInt(args[2]);
		int max=a;
		if(b>max)
		{
			max=b;
		}
		if(c>max)
		{
			max=c;
		}
		System.out.println("三者之间最大数为："+max);
	}
}

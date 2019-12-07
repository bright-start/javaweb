package 中国大学课后习题;

public class Prove {

	public static void main(String[] args) {
		int i;
		double sum=0;
		//验证第一个等式
		for(i=3;i<6;i++)
		{
			sum+=Math.pow(i, 3);
		}
		double result;
		result=Math.pow(6, 3);
		if(sum==result)
		{
			System.out.println("3^3+4^3+5^3=6^3 成立");
		}
		else
		{
			System.out.println("3^3+4^3+5^3=6^3  不成立");
		}
		//验证第二个等式
		sum=0;
		result=0;
		for(i=6;i<70;i++)
		{
			sum+=Math.pow(i, 3);
		}
		result=Math.pow(180, 3);

		if(sum==result)
		{
			System.out.println("6^3+7^3+...+69^3=180^3 成立");
		}
		else
		{
			System.out.println("6^3+7^3+...+69^3=180^3   不成立");
		}
		//找到一个满足此等式的等式
	
	}

}

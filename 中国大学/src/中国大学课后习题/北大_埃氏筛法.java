package 中国大学课后习题;

public class 北大_埃氏筛法 {
	
	public static void isPrime(int num)
	{
		boolean[] mark = new boolean[num+1];
		mark[0] = false;
		mark[1] = false;
		for(int i = 2; i <= num; i++)
		{
		     mark[i] = true;
		}
	    for(int i = 2; i <= Math.sqrt(num);i++)
	    {
	        if(mark[i] == true)
	        {
	            for(int j = i;j*i<=num;j++)
	            {
	                    mark[j*i] = false;
	            }
	        }
	    }
        int count = 0;
        System.out.println("0到"+num+"的素数是：");
        for(int i = 2; i<=num; i++)
        {
            if(mark[i] == true)
            {
                count++;
                System.out.print(i+"\t");
                if(count%10 == 0)
                {
                    System.out.println();
                }
            }
        }
        System.out.println("\n0到"+num+"中的素数一共有"+count+"个。");
    }
	
	public static void main(String[] args) {
        isPrime(100);
	}
}

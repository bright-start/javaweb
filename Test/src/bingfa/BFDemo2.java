package bingfa;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class BFDemo2 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("执行线程中。。。");
		Thread.sleep(2000);
		return 1;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		BFDemo2 bfDemo2 = new BFDemo2();
		FutureTask<Integer> futureTask = new FutureTask<>(bfDemo2);
		Thread thread = new Thread(futureTask);
		
		thread.start();
		System.out.println("执行检查。。。");
		
		Integer integer = futureTask.get();
		System.out.println(integer);
	}
	
}

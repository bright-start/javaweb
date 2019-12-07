package bingfa;

import java.util.concurrent.CountDownLatch;

public class PlayerTest {
	private static CountDownLatch countDownLatch = new CountDownLatch(1);
	private static CountDownLatch countDownLatch2 = new CountDownLatch(3);
	
	
	public static void main(String[] args) {
		for(int i = 0;i<3;i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println(Thread.currentThread()+"等待开炮");
						countDownLatch.await();
						System.out.println(Thread.currentThread()+"跑完");
						countDownLatch2.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		try {
			Thread.sleep(5000);
			System.out.println("信号发出");
			countDownLatch.countDown();
			System.out.println("等待跑完");
			countDownLatch2.await();
			Thread.sleep(2000);
			System.out.println("已跑完，等待成绩");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

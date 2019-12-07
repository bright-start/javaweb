package bingfa;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class MSGoodsTest {
	private final static int ALLUSER = 12;
	
	private static CountDownLatch countDownLatch = new CountDownLatch(ALLUSER);

	private static int allGoods = 4;
	
	private static int successBuyer = 0;
	
	@Test
	public void msbg() throws InterruptedException {
		for(int i = 1; i <= ALLUSER; i++) {
			new Thread(new BuyProduct(3)).start();
			if(i == ALLUSER) {
				Thread.sleep(2000);
			}
			countDownLatch.countDown();
		}
		Thread.sleep(3000);
		System.out.println("��Ʒʣ�ࣺ"+allGoods);
		System.out.println("�ɹ���������:"+successBuyer);
	}
	public class BuyProduct implements Runnable{
		private int num;
		
		public BuyProduct(int num) {
			this.num = num;
		}
		
		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread()+"�ȴ���ɱ");
				countDownLatch.await();
				
				Thread.sleep((long) (Math.random()*100));
				synchronized (countDownLatch) {
					if(allGoods - num < 0) {
						return ;
					}
					
					allGoods -= num;
					successBuyer += 1;
					System.out.println(Thread.currentThread()+"��ɱ�ɹ�������������������������������");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

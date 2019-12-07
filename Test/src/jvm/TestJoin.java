package jvm;

public class TestJoin {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("2");
			}
		});
		t.start();
		t.join();
		System.out.print("1");
	}
}

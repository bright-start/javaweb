package bingfa;

public class BFDemo  extends Thread{
	public BFDemo(String name) {
		super(name);
	}

	@Override
	public void run() {
		while(!interrupted()) {
			System.out.println(getName()+"线程执行了。。。");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		BFDemo bf1 = new BFDemo("first");
		BFDemo bf2 = new BFDemo("second");
		
		bf1.start();
		bf2.start();
		
		bf2.interrupt();
	}
	
}

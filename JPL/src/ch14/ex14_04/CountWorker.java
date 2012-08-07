package ch14.ex14_04;

public class CountWorker implements Runnable{

	private int value;
	private static final int NUM = 10;
	CountWorker(int value) {
		this.value = value;
	}
	
	public void run() {
		for(int i = 0; i < NUM; i++) {
			Counter.add(value);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String args[]) {
		new Thread(new CountWorker(3), "add3").start();
		new Thread(new CountWorker(5), "add5").start();
		new Thread(new CountWorker(7), "add7").start();
		new Thread(new CountWorker(11), "add11").start();
		new Thread(new CountWorker(13), "add13").start();
		new Thread(new CountWorker(17), "add17").start();
	}
}

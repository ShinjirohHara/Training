package ch14.ex14_03;

public class CountWorker implements Runnable{

	private Counter counter;
	private int value;
	private static final int NUM = 10;
	CountWorker(Counter counter, int value) {
		this.counter = counter;
		this.value = value;
	}
	
	public void run() {
		for(int i = 0; i < NUM; i++) {
			counter.add(value);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String args[]) {
		Counter counter = new Counter();
		new Thread(new CountWorker(counter, 3), "add3").start();
		new Thread(new CountWorker(counter, 5), "add5").start();
		new Thread(new CountWorker(counter, 7), "add7").start();
		new Thread(new CountWorker(counter, 11), "add11").start();
		new Thread(new CountWorker(counter, 13), "add13").start();
		new Thread(new CountWorker(counter, 17), "add17").start();
	}
}

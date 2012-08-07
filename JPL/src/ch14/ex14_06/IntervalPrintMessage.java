package ch14.ex14_06;

public class IntervalPrintMessage implements Runnable{

	private int interval;
	private int current = 0;
	private int printNum = 0;
	IntervalPrintMessage(int interval) {
		this.interval = interval;
	}
	

	public void run() {
		System.out.println(interval+"•bŠÔŠu‚ÅŒv‘ª‚ðŽn‚ß‚Ü‚·");
		while(true) {
			try {
				print();
			} catch (InterruptedException e) {
				break;
			}
		}
	}
	
	public synchronized void notifySecond() {
		current++;
		notifyAll();
	}
	private synchronized void print() throws InterruptedException{
		while(current != interval) {
			wait();
		}
		printNum++;
		current = 0;
		System.out.println(interval*printNum + "•bŒo‰ß‚µ‚Ü‚µ‚½.");
		
		
	}

}

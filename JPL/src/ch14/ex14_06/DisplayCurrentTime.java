package ch14.ex14_06;

public class DisplayCurrentTime {
	
	public static void main(String args[]) {
		
		IntervalPrintMessage worker15 = new IntervalPrintMessage(15);
		Thread thread = new Thread(worker15);
		thread.start();
		for (int i = 0; i < 60; i++) {
			worker15.notifySecond();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
		thread.interrupt();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		IntervalPrintMessage worker7 = new IntervalPrintMessage(7);
		thread = new Thread(worker7);
		thread.start();
		for (int i = 0; i < 60; i++) {
			worker7.notifySecond();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		thread.interrupt();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

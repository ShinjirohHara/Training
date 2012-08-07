package ch14.ex14_09;

public class DisplayCurrentTime {
	
	public static void main(String args[]) {
		System.out.println("print thread group."+Thread.currentThread().getThreadGroup().getName());
		new ThreadGroupMonitor(Thread.currentThread().getThreadGroup());
		
		IntervalPrintMessage worker15 = new IntervalPrintMessage(15);
		Thread thread = new Thread(worker15, "worker15");
		System.out.println("print thread group."+thread.getThreadGroup().getName());
		thread.start();
		for (int i = 0; i < 30; i++) {
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
		thread = new Thread(worker7, "worker7");
		
		thread.start();
		for (int i = 0; i < 30; i++) {
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

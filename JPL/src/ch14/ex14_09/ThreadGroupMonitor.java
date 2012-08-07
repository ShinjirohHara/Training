package ch14.ex14_09;

public class ThreadGroupMonitor implements Runnable {

	
	private ThreadGroup target;
	private Thread[] thread;
	private ThreadGroup[] threadGroup;
	private static final int MAX_ELEMENT_NUM = 10;
	ThreadGroupMonitor(ThreadGroup target) {
		this.target = target;
		thread = new Thread[MAX_ELEMENT_NUM];
		threadGroup = new ThreadGroup[MAX_ELEMENT_NUM];
		Thread thread = new Thread(this, "Monitor");
		thread.setDaemon(true);
		thread.start();
		
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println("=== PrintThreadGroup["+target.getName()+"]=======");
				printThreadGroup(target);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}


	private void printThreadGroup(ThreadGroup target) {
		printThread(target);
		int num = target.enumerate(threadGroup, true);
		for (int i = 0; i < num; i++) {
			System.out.println("Thread Group Name:"+threadGroup[i].getName());
			printThreadGroup(threadGroup[i]);
		}
	}
	
	private void printThread(ThreadGroup target) {
		int num = target.enumerate(thread, true);
		for (int i = 0; i < num; i++) {
			System.out.println("Thread Name:"+thread[i].getName());
		}
	}
	
	
}

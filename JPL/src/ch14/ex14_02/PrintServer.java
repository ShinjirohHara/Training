package ch14.ex14_02;


public class PrintServer implements Runnable{

	private Thread worker = new Thread(this);
	
	public PrintServer() {
		worker.start();
	}
	
	public void run() {
		if (Thread.currentThread().getId() == worker.getId()) {
			System.out.println("Thread start");
			realPrint();
		} else {
			System.out.println("illegal call");
		}
	}
	
	private void realPrint() {
	}
	
	public static void main(String args[]) {
		PrintServer server = new PrintServer();
		server.run();
	}
}

package ch14.ex14_05;

public class Counter {
	static Integer VALUE = 0;
	
	static public int add(int arg) {
		synchronized (VALUE) {
			VALUE += arg;
			System.out.println("ThreadName:"+ Thread.currentThread().getName()+", Value:"+ VALUE);
			return VALUE;
		}
	}
}

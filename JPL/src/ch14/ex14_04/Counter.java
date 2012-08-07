package ch14.ex14_04;

public class Counter {
	static int VALUE = 0;
	
	static public synchronized int add(int arg) {
		VALUE += arg;
		System.out.println("ThreadName:"+ Thread.currentThread().getName()+", Value:"+ VALUE);
		return VALUE;
	}
}

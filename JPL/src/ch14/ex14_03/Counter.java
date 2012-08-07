package ch14.ex14_03;

public class Counter {
	int value = 0;
	
	public synchronized int add(int arg) {
		value += arg;
		System.out.println("ThreadName:"+ Thread.currentThread().getName()+", Value:"+ value);
		return value;
	}
}

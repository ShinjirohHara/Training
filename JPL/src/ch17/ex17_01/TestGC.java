package ch17.ex17_01;

import java.util.ArrayList;
import java.util.List;

public class TestGC {
	public static void main (String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println("Free Memory:"+rt.freeMemory());
		
		System.out.println("Start memory alloc");
		
		List<byte[]> refList = new ArrayList<byte[]>();
		for (int i = 0; i < 10000; i++) {
			refList.add(new byte[1024]);
		}
		
		System.out.println("Free Memory:"+rt.freeMemory());
		
		System.out.println("Start GC");
		refList.clear();
		rt.runFinalization();
		rt.gc();
		System.out.println("Free Memory:"+rt.freeMemory());
		
	}

}

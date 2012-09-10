package ch17.ex17_04;

import java.lang.ref.*;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
	
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	final Thread reaper;
	boolean shutdown = false;
	
	class ReaperThread extends Thread {
		public void run() {
			boolean isInterrupt = false;
			// 割り込まれていないか、割り込まれてかつからでない場合は続ける
			while (!isInterrupt || !refs.isEmpty() && isInterrupt) {
					
				System.out.println("enter ReaperThread");
				try {
					Reference<?> ref = queue.remove();
					System.out.println("get reference");
					Resource res = null;
					synchronized(ResourceManager.this) {
						res = refs.get(ref);
						refs.remove(ref);
					}
					
					res.release();
					ref.clear();
				} catch (InterruptedException ie) {
					System.out.println("interrupt occured");
					if (!isInterrupt)
						isInterrupt = true;
					else {
						throw new IllegalStateException("two times interrupt occured");
					}
				}
				
			}
			System.out.println("end ReaperThread");
		}
	}
	
	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		reaper = new ReaperThread();
		reaper.start();
	}
	
	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			reaper.interrupt();
		}
	}
	
	public synchronized Resource getResource(Object key) {
		if (shutdown)
			throw new IllegalStateException();
		
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref, res);
		return res;
	}
	
	public static void main(String[] args) {
		ResourceManager rm = new ResourceManager();
		for (int i = 0; i < 100000; i ++)
			rm.getResource(new Object());
		
		rm.shutdown();
		Runtime.getRuntime().runFinalization();
	}

}

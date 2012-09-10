package ch17.ex17_03;

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
			while (true) {
				try {
					Reference<?> ref = queue.remove();
					Resource res = null;
					synchronized(ResourceManager.this) {
						res = refs.get(ref);
						refs.remove(ref);
					}
					res.release();
					ref.clear();
				} catch (InterruptedException ie) {
					break;
				}
			}
			System.out.println("end ReapterThread");
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
		Resource resource = rm.getResource("SHARA");
		resource = rm.getResource("SHINJIROH");
		resource = null;
		rm.shutdown();
		
	}

}

package ch17.ex17_05;

import java.lang.ref.*;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
	
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	boolean shutdown = false;
	
	
	
	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
	}
	
	
	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			while (!refs.isEmpty()) {
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
					throw new IllegalStateException("two times interrupt occured");
				}
			}
		}
	}
	
	
	public synchronized Resource getResource(Object key) {
		if (shutdown)
			throw new IllegalStateException();
		
		Reference<? extends Object> ref;
		while( (ref = queue.poll()) != null ) {
			Resource res = null;
			synchronized(ResourceManager.this) {
				res = refs.get(ref);
				refs.remove(ref);
			}
			res.release();
			ref.clear();
		}
		
		Resource res = new ResourceImpl(key);
		ref = new PhantomReference<Object>(key, queue);
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

package ch17.ex17_04;

import java.lang.ref.*;

public class ResourceImpl implements Resource{
	WeakReference<Object>  ref;
	boolean needsRelease = false;
	byte[] resource = new byte[1024];
	
	ResourceImpl(Object key) {
		if (key == null)
			throw new NullPointerException("key is null");
		
		this.ref = new WeakReference<Object>(key);
		this.needsRelease = true;
	}
	
	public void user(Object key, Object... args) {
		if (ref.get() == null
				|| !ref.get().equals(key))
			throw new IllegalArgumentException("wrong key");
	}
	
	public synchronized void release() {
		if (needsRelease) {
			System.out.println("called release");
			needsRelease = false;
		}
	}
	


}

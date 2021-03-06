package ch22.ex22_04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;

public class ObservableAttributed extends Observable implements Attributed{

	private Set<Attr> attrSet = new HashSet<Attr>(); 
			
	@Override
	public void add(Attr newAttr) {
		if (!attrSet.contains(newAttr))
			notifyObservers(newAttr);
		
	}

	@Override
	public Attr find(String attrName) {
		
		for (Attr attr : attrSet)
			if(attr.getName().equals(attrName))
				return attr;
		
		return null;
	}

	@Override
	public Attr remove(String attrName) {
		
		for (Attr attr : attrSet)
			if (attr.getName().equals(attrName)) {
				attrSet.remove(attr);
				notifyObservers(attr);
				return attr;
			}
		
		return null;
	}

	@Override
	public Iterator<Attr> attrs() {

		return attrSet.iterator();
	}

}

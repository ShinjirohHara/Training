package ch21.ex21_04;


import java.util.ListIterator;


public class ShortStrings implements ListIterator<String> {
	
	private ListIterator<String> strings;
	private int maxLen;


	ShortStrings(ListIterator<String> strings, int maxLen) {
		
		this.strings = strings;
		this.maxLen = maxLen;

	}

	@Override
	public void add(String e) {
		strings.add(e);
	}

	@Override
	public boolean hasNext() {
		if (next() != null) {
			previous();
			return false;
		} else {
			previous();
			return true;
		}
	}

	@Override
	public boolean hasPrevious() {
		if (previous() != null) {
			next();
			return false;
		} else {
			next();
			return true;
		}
	}

	@Override
	public String next() {
		
		while(strings.hasNext()) {
			String nextShort = strings.next();
			if (nextShort.length() <= maxLen) {
				return nextShort;
			}
		}
		return null;
	}

	@Override
	public int nextIndex() {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public String previous() {
		while (strings.hasPrevious()) {
			String previousShort = strings.previous();
			if (previousShort.length() <= maxLen) {
				return previousShort;
			}
		}
		return null;
	}

	@Override
	public int previousIndex() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove() {
		strings.remove();
	}

	@Override
	public void set(String e) {

		strings.set(e);
	}

}

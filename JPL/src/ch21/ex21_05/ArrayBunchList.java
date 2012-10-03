package ch21.ex21_05;

import java.util.AbstractList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayBunchList<E> extends AbstractList<E> {
	
	private class ABLListIterator implements ListIterator <E> {
		
		private int off;
		private int array;
		private int pos;
		private boolean isAbleToSet = false;
		
		ABLListIterator() {
			off = 0;
			array = 0;
			pos = 0;
			for (array = 0; array < arrays.length; array++) {
				if (arrays[array].length > 0)
					break;
			}
		}

		@Override
		public void add(E e) {
			
			
		}

		@Override
		public boolean hasNext() {
			return (off + pos + 1) < size();
		}

		@Override
		public boolean hasPrevious() {
			return (off + pos -1) > 0;
		}

		@Override
		public E next() {
			isAbleToSet = true;
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			pos++;
			while (pos >= arrays[array].length) {
				off += arrays[array++].length;
				pos = 0;
				if (array >= arrays.length)
					break;
			}
			return arrays[array][pos];
		}

		@Override
		public int nextIndex() {
			return (off + pos +1)< size() ? (off + pos + 1) :size();
		}

		@Override
		public E previous() {
			isAbleToSet = true;
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			
			pos--;
			while (pos < 0) {
				array--;
				if (array < 0) {
					throw new AssertionError();
				}
				off -= arrays[array].length;
				pos += arrays[array].length;
				
			}
				
			return arrays[array][pos];
		}
		

		@Override
		public int previousIndex() {
			return off + pos -1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(E e) {
			if (isAbleToSet)
				arrays[array][pos] = e;
			
			throw new UnsupportedOperationException();
		}
		
	}

	private final E[][] arrays;
	private final int size;

	public ArrayBunchList(E[][] arrays) {
		this.arrays = arrays.clone();
		int s = 0;
		for (E[] array: arrays)
			s += array.length;
		size = s;
	}
	
	
	@Override
	public E get(int index) {
		int off = 0;
		for (int i = 0; i < arrays.length; ++i) {
			if ( index < off + arrays[i].length)
				return arrays[i][index - off];
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

	@Override
	public int size() {
		return size;
	}
	
	public E set(int index, E value) {
		int off = 0;
		for (int i = 0; i < arrays.length; ++i) {
			if (index < off + arrays[i].length) {
				arrays[i][index - off] = value;
				return value;
			}
				
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

}

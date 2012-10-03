package ch22.ex22_15;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;


// 継承よりコンポジションといわれているので、コンポジションを使用する
// 継承の場合、Listの恩恵を受けられるが、ArrayListの仕様を満たさなければならないので、仕様変更等面倒・・・

public class ArrayStack<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<E> list = new ArrayList<E>();
	
	public ArrayStack() {
		
	}
	
	public boolean empty() {
		return !(list.size() > 0);
	}

	public E peek() {
		if (empty()) throw new EmptyStackException();
		return list.get(list.size() - 1);
	}
	
	public E pop() {
		if (empty()) throw new EmptyStackException();
		return list.remove(list.size() - 1);
		
	}
	
	public E push(E item) {
		if (item == null) throw new NullPointerException();
		if (list.add(item)) return item;
		throw new AssertionError();
	}
	
	public int search(E item) {
		
		if (item == null) throw new NullPointerException();
		
		for (int i = 1; i < list.size()+1; i++) {
			if (item.equals(list.get(list.size() - i))) {
				return i;
			}
		}
		return -1;
	}
	
	public int getSize() {
		return list.size();
	}
	

}

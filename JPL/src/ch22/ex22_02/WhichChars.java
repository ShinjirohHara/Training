package ch22.ex22_02;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

public class WhichChars {
	private BitSet used = new BitSet();
	private HashSet<Character> usedSet = new HashSet<Character>();
	
	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) > 0xFF) {
				usedSet.add(str.charAt(i));
			} else {
				used.set(str.charAt(i));
			}
	}
	public String toString() {
		String desc = "[";
		for (int i = used.nextSetBit(0);
				i >=0;
				i = used.nextSetBit(i+1)) {
			desc += (char) i;
				}
		for (Iterator<Character> ite = usedSet.iterator(); ite.hasNext();)
			desc +=ite.next();
		
		return desc + "]";
	}
	
	public static void main(String[] args) {
		System.out.println(new WhichChars("abec 原真二郎").toString());
		
	}
}

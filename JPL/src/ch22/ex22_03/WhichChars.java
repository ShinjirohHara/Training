package ch22.ex22_03;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class WhichChars {
	private HashMap<Byte, BitSet> usedMap = new HashMap<Byte, BitSet>(); 
	

	public WhichChars(String str) {
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			Byte high = new Byte((byte) (c >> 8));
			int low =  (c & 0xFF);
			if (usedMap.containsKey(high)) {
				usedMap.get(high).set(low);
			} else {
				BitSet used = new BitSet();
				used.set(low);
				usedMap.put(high, used);
			}
		}
	}
	public String toString() {
		String desc = "[";
		for (Entry<Byte,BitSet> entry : usedMap.entrySet()) {
			char c = (char) (entry.getKey() << 8);
			BitSet used = entry.getValue();
			for (int i = used.nextSetBit(0); i>=0; i=used.nextSetBit(i+1)) {
				desc += (char)(c+i);
			}
		}
		return desc + "]";
	}

	
	public static void main(String[] args) {
		System.out.println(new WhichChars("abec 原真二郎").toString());
		
	}
}

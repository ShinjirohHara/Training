package ch21.ex21_02;

import java.io.File;
import java.util.WeakHashMap;

public class DataHandler {
	
	private WeakHashMap<File, byte[]> dataMap;
	
	
	byte[] readFile(File file) {
		if (dataMap.containsKey(file))
			return dataMap.get(file);
		
	
		
		byte[] result = readBytesFromFile(file);
		dataMap.put(file, result);
		return result;
	}

	private byte[] readBytesFromFile(File file) {
		return new byte[10];
	}

}

package ch20.ex20_03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream{

	private byte key;
	protected DecryptInputStream(InputStream in, byte key) {
		super(in);
		this.key = key;
	}
	
	public int read() throws IOException {
		return ((byte)super.read())^key;
	}
	
	
	public static void main(String[] args) throws IOException{
		byte key = 123;
		DecryptInputStream in = new DecryptInputStream(System.in, key);
		EncryptOutputStream out = new EncryptOutputStream(System.out, key);

		int b;
		while((b = in.read()) != -1) { 
			out.write(b);
		}
	}
}

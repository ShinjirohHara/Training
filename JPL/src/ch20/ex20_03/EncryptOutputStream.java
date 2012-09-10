package ch20.ex20_03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream{

	private byte key;
	protected EncryptOutputStream(OutputStream out, byte key) {
		super(out);
		this.key = key;
	}
	
	public void write(int b) throws IOException {
		super.write(((byte) b)^key);
	}
}

package ch20.ex20_02;


import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TranslateByte extends FilterInputStream {
	private byte from;
	private byte to;

	
	TranslateByte(InputStream in, byte from, byte to) {
		super(in);
	}
	
	public  int read() throws IOException{
		
		int c = super.read();
		return (c == from ? to : c);
	}
	
	
	public static void main(String[] args) throws IOException{
		byte from = (byte)args[0].charAt(0);
		byte to = (byte)args[1].charAt(0);
		
		TranslateByte tb = new TranslateByte(System.in, from, to);
		int b;
		while ((b = tb.read()) != -1)
			System.out.write(b);
	}
	

}

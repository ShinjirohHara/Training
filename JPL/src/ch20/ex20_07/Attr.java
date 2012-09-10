package ch20.ex20_07;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;


public class Attr {
	private final String name;
	private String value = null;
	
	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public Attr(DataInputStream in) throws IOException {
		name = in.readUTF();
		value = in.readUTF();
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
	public Object setValue(String newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	public void writeDataToOutputStream(DataOutputStream out) throws IOException{
		out.writeUTF(name);
		out.writeUTF(value);
	}
	
	public String toString() {
		return name + "='" + value + "'";
	}
	
	public int hashCode() {
		int result = 17;
		int multi = 31;
		result = result * multi + name.hashCode();
		if (value != null) {
			result = result * multi + value.hashCode();
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(byteArray);
		Attr attr = new Attr("name", "value");
		attr.writeDataToOutputStream(out);
		attr = new Attr("name1", "value2");
		attr.writeDataToOutputStream(out);
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(byteArray.toByteArray()));
		
		System.out.println(new Attr(in));
		System.out.println(new Attr(in));
		
	}
}

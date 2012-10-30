package ch23.ex23_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ProcessSample {
	public static void main(String[] args) throws IOException{
		// ctl-Zで終了
		userProg("dir");
	}
	
	public static Process userProg(String cmd) throws IOException{
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogegher(System.in, proc.getOutputStream());
		plugTogegher(System.out, proc.getInputStream());
		plugTogegher(System.err, proc.getErrorStream());
		return proc;
		
	}

	private static void plugTogegher(final PrintStream print, final InputStream input) {
		
		Runnable run = new Runnable() {
			@Override
			public void run() {
				int c;
				try {
					while ((c = input.read()) != -1) {
						print.write(c);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		};
		
		Thread thread = new Thread(run);
		thread.start();
		
	}

	private static void plugTogegher(final InputStream input, final OutputStream print) {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				int c;
				try {
					while ((c = input.read()) != -1) {
						print.write(c);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		};
		
		Thread thread = new Thread(run);
		// thread.setDaemon(true);
		thread.start();
		
		
	}

}

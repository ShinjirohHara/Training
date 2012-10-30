package ch23.ex23_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;

public class ProcessSample {
	private static int lineNo = 1;

	
	public static Process userProg(String cmd) throws IOException{
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogegher(System.out, proc.getInputStream());
		plugTogegher(System.err, proc.getErrorStream());
				
		return proc;
	}

	private static void plugTogegher(final PrintStream print, final InputStream input) {
		
		Runnable run = new Runnable() {
			@Override
			public void run() {
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				try {
					String line = "";
					while ((line = reader.readLine()) != null) {
						print.print(lineNo++);
						print.println(":"+line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		};
		
		Thread thread = new Thread(run);
		thread.start();
		
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cmd;
		String hostName = InetAddress.getLocalHost().getHostName();
		String userName = System.getProperty("user.name");
		
		while (true) {
			System.out.print(userName+"@"+hostName+" % ");
			cmd = br.readLine();
			if (cmd.equals("exit")) {
				System.out.println("Good bye");
				break;
			} else if (cmd.equals("")) {
				continue;
			}
			
			
			Process proc = userProg(cmd);
			try {
				proc.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	

}

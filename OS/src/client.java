import java.net.*;
import java.io.*;
import java.util.Scanner;



public class client {

	public static void main(String[] args) {
		
		System.out.println("Client starting...");
		
		try {
			
			
			InetAddress LocalHost = InetAddress.getLocalHost();
			Socket cs = new Socket("LocalHost",3702);
			PrintWriter pw = new PrintWriter(cs.getOutputStream(), true);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			
			System.out.println("Connected to the server...");
			Scanner scanner = new Scanner(System.in);
			
			while(true) {
				System.out.println("Enter Text:");
				String input = scanner.nextLine();
				
				if ("exit".equalsIgnoreCase(input)) {
					break;
				}
				
				pw.println(input);
				String response = bufferedReader.readLine();
				System.out.println("From server:"+response);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

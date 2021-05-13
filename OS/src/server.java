import java.net.*;
import java.io.*;



public class server {
	public static void main(String[] args){
		
		System.out.println("Server is now starting");
		
		try(ServerSocket ss = new ServerSocket(3702)) {
			
			Socket cs = ss.accept();
			System.out.println("Connection is established...");
			
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			PrintWriter pw = new PrintWriter(cs.getOutputStream(), true);
			
			
			String line;
			while((line = bufferedReader.readLine()) != null ) {
				System.out.println("From client :" +line);
				pw.println(line);
			}
			
			
			
			
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

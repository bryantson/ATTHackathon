import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class NetworkconnectionServer {

	/**
	* @param args
	*/
	
	static ServerSocket server; 
	static Socket client = null;;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		try{
			
		  server = new ServerSocket(0); 
		 
		  System.out.println(server.getLocalPort());
		  while(true){
			 
			  client = server.accept();
			  BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			 
			  System.out.println(in.readLine());
			 
			  }
		  } catch (IOException e) {
		    System.out.println("Could not listen on port 0");
		    e.printStackTrace();
		    System.exit(-1);
		  }
		
		catch(Exception e) {
			System.out.println("Exception " + e);
			e.printStackTrace();
		}
			 
	}



}

/**
 * @author Derek Huang, Bryant Son
 */
package com.derhuang.networkconnection;


// Test
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	Socket socket;
	InetAddress sockaddr;
	String ipAddr = "10.0.1.20";
	int port = 8011;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		

		return true;
	}
	
	 class ClientThread implements Runnable {
		 
		  
		 
		         @Override
		 
		         public void run() {
		 
		  
		 
		             try {
		 
		                 InetAddress serverAddr = InetAddress.getByName(ipAddr);
		                 socket = new Socket(serverAddr, port);
		 
		  
		 
		             } catch (UnknownHostException e1) {
		 
		                 e1.printStackTrace();
		 
		             } catch (IOException e1) {
		 
		                 e1.printStackTrace();
		 
		             }

		         }

		     }
	 public void sendMessage(View view) {
		 
		 new Thread(new ClientThread()).start();
		 
		 PrintWriter out = null;
		         try {
		
		 
		             String str = "Hello Pi";
		
		             out = new PrintWriter(new BufferedWriter(
		 
		                     new OutputStreamWriter(socket.getOutputStream())),
		 
		                     true);
		 
		             out.println(str);
		             out.println(str);
		  
		 
		         } catch (UnknownHostException e) {
		 
		             e.printStackTrace();
		 
		         } catch (IOException e) {
		 
		             e.printStackTrace();
		 
		         } catch (Exception e) {
		 
		             e.printStackTrace();
		 
		         } finally{
		        	 
		         }
		     }


   /* 
    public void sendMessage(View view){
    	//Intent intent = new Intent(this, ConnectionToNetwork.class);
    	//EditText editText = (EditText) findViewById(R.id.edit_message);
    	//String message = "Hello Pi";
    	//intent.putExtra(EXTRA_MESSAGE,message);
    	//startActivity(intent);
    	Toast.makeText(getApplicationContext(), "button clicked", Toast.LENGTH_SHORT).show();
		try {
			sockaddr = InetAddress.getByName(ipAddr);
			socket = new Socket(sockaddr, port);
		} 
		catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				

		try{
	        PrintWriter out = new PrintWriter(new BufferedWriter(
	                new OutputStreamWriter(socket.getOutputStream())),
	                true);
		        out.println("hi pi");
		    } catch (UnknownHostException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
    }*/
}

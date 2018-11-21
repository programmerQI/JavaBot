package com.test1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class MyServer1 {
	
	public static void main(String []arg0) {
		MyServer1 mServer1 = new MyServer1();
	}
	
	public MyServer1()
	{
		try {
			// ss is listenning at port 9999
			ServerSocket serverSocket = new ServerSocket(9999);
			System.out.println("Listening...");
			
			// waiting someone connect to the prot. Return a Scoket connection
			Socket socket = serverSocket.accept();
			System.out.println("Accept");
			
			// to read the data from the client
			InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
			BufferedReader bReader = new BufferedReader(inputStreamReader); // use Buffer
			
			String info = bReader.readLine();
			System.out.println("The server recived : " + info );
			
			// reply the client
			PrintWriter pWriter = new PrintWriter(socket.getOutputStream(), true);
			pWriter.println("This is a server");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

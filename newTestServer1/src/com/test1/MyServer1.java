package com.test1;
import java.io.IOException;
import java.net.*;

public class MyServer1 {
	
	public static void main(String []arg0) {
		MyServer1 mServer1 = new MyServer1();
	}
	
	public MyServer1()
	{
		try {
			// ss is listenning at port 9999
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("Listening...");
			
			// waiting someone connect to the prot. Return a Scoket connection
			Socket s = ss.accept();
			System.out.println("Accept");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
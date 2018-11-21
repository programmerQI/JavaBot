package com.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient2 {

	public static void main(String[] args) {
		
		MyClient2 myClient2 = new MyClient2();

	}
	
	public MyClient2() {
		try {
			
			// connect to the server
			Socket socket = new Socket("127.0.0.1", 9999);
			
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
			
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			InputStreamReader inputStreamReader2 = new InputStreamReader(socket.getInputStream());
			BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
			
			while(true) {
				
				System.out.println("Tell the server: ");
				String string = bufferedReader.readLine();
				//System.out.println(string);
				
				printWriter.println(string);
				if(string.equals("Bye")) {
					socket.close();
					break;
				}
				
				String string2 = bufferedReader2.readLine();
				System.out.println("The server replies: " + string2 );
				
				
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

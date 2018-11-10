package com.test1;
import java.io.IOException;
import java.net.*;

public class MyClient1 {
	
	public static void main(String[] args) {
		MyClient1 myClient1 = new MyClient1();
	}
	
	public MyClient1() {
		try {
			// Socket() is for connecting some server with ip and port.
			Socket socket = new Socket("127.0.0.1",9999);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}

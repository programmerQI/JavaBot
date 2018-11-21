package com.test3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyServer3 extends JFrame{
	
	private JPanel jPanel;
	private JTextField jTextField;
	private JButton jButton;

	private JScrollPane jScrollPane;
	private JTextArea jTextArea;
	
	private ServerSocket serverSocket;
	private Socket socket;
	private PrintWriter printWriter;
	private InputStreamReader inputStreamReader;
	private BufferedReader bufferedReader;
	
	public void Servering() {
		try {
			
			serverSocket = new ServerSocket(9999);
			
			System.out.println("Listening...");
			socket=serverSocket.accept();
			System.out.println("Connected!");
			
			printWriter = new PrintWriter(socket.getOutputStream(),true);
			
			inputStreamReader = new InputStreamReader(socket.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);
			
			while(true) {
				
				String string = bufferedReader.readLine();
				System.out.println(string);
				jTextArea.append("Client: "+string+"\r\n");
				
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int send() {
		if( printWriter == null || jTextField == null || jTextArea == null) {
			return -1;
		}
		
		String string = jTextField.getText();
		printWriter.println(string);
		jTextArea.append("Server: "+string+"\r\n");
		
		// auto clean JTestField
		jTextField.setText("");
		
		return 1;
	}
	
	public MyServer3() {
		
		jPanel = new JPanel();
		jTextField = new JTextField(20);
		jButton = new JButton("Send");
		jPanel.add(jTextField);
		jPanel.add(jButton);
		this.add(jPanel,"South");
		
		jTextArea = new JTextArea();
		jScrollPane = new JScrollPane(jTextArea);
		this.add(jScrollPane,"Center");
		
		setSize(500, 300);
		setTitle("Server");
		setVisible(true); 
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(e.getSource()==jButton) {
					System.out.println(send());
				}
				
			}
		});
		
		Servering();
	}
	
	public static void main(String[] args) {
		MyServer3 myServer3= new MyServer3();
	}
}

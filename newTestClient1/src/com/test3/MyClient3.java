package com.test3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyClient3 extends JFrame{
	
	private JPanel jPanel;
	private JTextField jTextField;
	private JButton jButton;

	private JScrollPane jScrollPane;
	private JTextArea jTextArea;
	
	private Socket socket;
	private PrintWriter printWriter;
	private InputStreamReader inputStreamReader;
	private BufferedReader bufferedReader;
	
	public int send() {
		if( printWriter == null || jTextField == null || jTextArea == null) {
			return -1;
		}
		
		String string = jTextField.getText();
		printWriter.println(string);
		jTextArea.append("Client: "+string+"\r\n");
		
		// auto clean JTestField
		jTextField.setText("");
		
		return 1;
	}
	
	public void Connecting() {
		try {
			
			socket = new Socket("127.0.0.1",9999);
			
			printWriter = new PrintWriter(socket.getOutputStream(),true);
			inputStreamReader = new InputStreamReader(socket.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);
			
			while(true) {
				
				String string = bufferedReader.readLine();
				System.out.println(string);
				jTextArea.append("Server: "+string+"\r\n");
				
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public MyClient3 () {
		
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
		setTitle("Client");
		setVisible(true);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(send());
				
			}
		});
		
		Connecting();
	}
	
	
	
	public static void main(String[] args) {
		MyClient3 myClient3 = new MyClient3();
	}
	
}

package com.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ConnectionTCPClient {
	int serverPort;
	String hostName;
	
	ConnectionTCPClient (String hostName,int serverPort){
		this.hostName=hostName;
		this.serverPort=serverPort;
	}
	
	public void connection() {
		Socket socket = null;
		try {
			//int serverPort = 7896;
			//String host = "127.0.0.1";// host server, silahkan diganti jika server
			socket = new Socket(this.hostName, this.serverPort);
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(

					socket.getOutputStream());

			Scanner input = new Scanner(System.in);
			System.out.print("Inputkan Data yang akan di submit : ");
			String dataInput = input.nextLine();
			outputStream.writeUTF(dataInput);
			String dataRecive = inputStream.readUTF();
			System.out.println("Received: " + dataRecive);
			input.close();
		} catch (UnknownHostException e) {
			System.out.println("Sock:" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		} finally {
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("close:" + e.getMessage());
				}

		}

	}
	
	public void init() {
		this.connection();
	}
}
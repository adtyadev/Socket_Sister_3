package com.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionTCPServer extends Thread {
	DataInputStream in;
	DataOutputStream out;
	ServerSocket listenSocket = null;

	public ConnectionTCPServer(int serverPort) throws IOException {
		listenSocket = new ServerSocket(serverPort);
	}

	public void Connection() {
		try {
			System.out.println("Server sedang running.........");
			Socket clientSocket = listenSocket.accept();
			this.in = new DataInputStream(clientSocket.getInputStream());
			this.out = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Connection:" + e.getMessage());
		}
	}

}

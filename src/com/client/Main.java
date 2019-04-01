package com.client;

public class Main {

	public static void main(String[] args) {
		ConnectionTCPClient connection = new ConnectionTCPClient("127.0.0.1",7896);
		connection.init();
	}

}

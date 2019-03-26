package com.modul;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args) {
		Socket s = null;
		try {
			int serverPort = 7896;
			String host = "127.0.0.1";// host server, silahkan diganti jika server
			s = new Socket(host, serverPort);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(

					s.getOutputStream());

			Scanner sc = new Scanner(System.in);
			System.out.print("Inputkan Data yang akan di submit : ");
			String input = sc.nextLine();
			out.writeUTF(input);
			String data = in.readUTF();
			System.out.println("Received: " + data);
			sc.close();
		} catch (UnknownHostException e) {
			System.out.println("Sock:" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		} finally {
			if (s != null)
				try {
					s.close();
				} catch (IOException e) {
					System.out.println("close:" + e.getMessage());
				}

		}

	}
}
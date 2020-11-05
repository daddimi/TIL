package com.tcpip;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	int port;
	ServerSocket serverSocket;
	Socket socket;
	
	public Server() {}
	public Server(int port) {
		this.port = port;
		
	}
	class Receiver extends Thread {
		DataInputStream dis;
		Socket socket = null;
		public Receiver (Socket socket) {
			this.socket = socket;
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while(dis != null) {
				String msg = "";
				try {
					msg = dis.readUTF();
					if(msg.equals("q")) {
						System.out.println("Someone Exit..");
						break;
					}
					System.out.println(msg);
				} catch (IOException e) {
					System.out.println("Someone Exit..");
					break;
				}
			}
			if(dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public void startServer() throws Exception {
		System.out.println("TCP/IP Server Start");
		try {
			serverSocket = new ServerSocket(port);
			while(true) {
				System.out.println("Ready Server..");
				socket = serverSocket.accept();
				System.out.println("Connected");
				new Receiver(socket).start();
			}
		} catch(Exception e) {
			throw e;
		}
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server(7777);
		server.startServer();
	}

}

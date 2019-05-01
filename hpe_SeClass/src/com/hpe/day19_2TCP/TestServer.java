package com.hpe.day19_2TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * TCP键盘传输服务端
 */
public class TestServer {
	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket server = null;
		try {
			server = new ServerSocket(Integer.parseInt(args[0]));
			System.out.println("the server port is "+ Integer.parseInt(args[0]));
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				socket = server.accept();
				InputStream ins = socket.getInputStream();
				DataInputStream dins = new DataInputStream(ins);
				String content = dins.readUTF();
				System.out.println(content);
				ins.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
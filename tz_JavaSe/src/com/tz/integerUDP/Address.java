package com.tz.integerUDP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Address {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet);
		String host = inet.toString();
		String[] str = host.split("/");
		for (String s : str) {
			System.out.println(s);
		}
		System.out.println();
		
		InetAddress inet1 = InetAddress.getByName("127.0.0.1");
		String s1 = inet1.getHostAddress();
		String s2 = new String("127.0.0.1");
		System.out.println(s1.equals(s2));
	}

}

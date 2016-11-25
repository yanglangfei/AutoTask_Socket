package com.jc.utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketUtils {
	
	private static SocketUtils utils;
	private static ServerSocket serverSocket;
	private SocketUtils(){
		
	}
	
	public static SocketUtils getInstance() throws IOException{
		if(utils==null){
			utils=new SocketUtils();
			serverSocket=new ServerSocket(8888);
		}
		return utils;
	}
	
	public Socket accept() throws IOException{
		return serverSocket.accept();
	}
}

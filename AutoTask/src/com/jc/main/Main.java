package com.jc.main;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.jc.service.ReadHandle;
import com.jc.service.WriteHandle;
import com.jc.utils.SocketUtils;

public class Main {
	private static Map<Integer, Socket> soMap=new HashMap<>();
	public static void main(String[] args) {
		// 1������UI
		// 2������Socket 
		try {
			SocketUtils utils=SocketUtils.getInstance();
			while (true) {
				Socket socket=utils.accept();
				System.out.println("���ӳɹ���"+socket.getPort());
				soMap.put(socket.getLocalPort(), socket);
				new ReadHandle(soMap,socket).start();
				new WriteHandle(soMap,socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

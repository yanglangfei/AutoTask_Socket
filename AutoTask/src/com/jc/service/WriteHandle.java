package com.jc.service;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;

import com.jc.service.ReadHandle.OnReceiverMsg;

public class WriteHandle extends Thread{
	
	private Map<Integer, Socket> soMap;
	private Socket socket;
	private DataOutputStream dos;

	public WriteHandle(Map<Integer, Socket> soMap, Socket socket) throws IOException {
		this.soMap=soMap;
		this.socket=socket;
		OutputStream os=socket.getOutputStream();
		dos=new DataOutputStream(os);
	}

	@Override
	public void run() {
		try {
			new ReadHandle(soMap, socket).setOnReceiverMsg(new OnReceiverMsg() {
				
				@Override
				public void onSuccess(String msg) {
					try {
						dos.writeUTF(msg);
						dos.flush();
						dos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				@Override
				public void onFail(String error) {
					
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

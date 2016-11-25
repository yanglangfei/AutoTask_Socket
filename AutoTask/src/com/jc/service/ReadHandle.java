package com.jc.service;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Map;

public class ReadHandle extends Thread{
	private OnReceiverMsg onReceiverMsg;
	private InputStream is;
	public void setOnReceiverMsg(OnReceiverMsg onReceiverMsg) {
		this.onReceiverMsg = onReceiverMsg;
	}

	public ReadHandle(Map<Integer, Socket> soMap, Socket socket) throws IOException {
		 is=socket.getInputStream();
	}

	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			 dis=new DataInputStream(is);
			String str=dis.readUTF();
			if(onReceiverMsg!=null&&str.length()>0){
				onReceiverMsg.onSuccess(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	public interface OnReceiverMsg{
		void onSuccess(String msg);
		void onFail(String error);
	}

}

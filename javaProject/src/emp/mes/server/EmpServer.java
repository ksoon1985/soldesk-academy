package emp.mes.server;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import emp.dto.EmpDTO;

public class EmpServer {
	private int port = 9000;
	
	public void receive() {
		ServerSocket ss = null; //서버 소켓
		
		try {
			ss = new ServerSocket(port);
			System.out.println("ServerSocket ok. port ="+port);
			
		} catch(Exception e) {
			System.err.println(e);
		}
		
		while(true) {
			Socket s = null; // 클라 소켓 
			ObjectInputStream ois = null;
			
			try {
				System.out.println("server ready...");
				
				s = ss.accept();
				
				ois = new ObjectInputStream(s.getInputStream());
				
				while(true) {
					EmpDTO e = (EmpDTO) ois.readObject();
					if(e == null) break;
					System.out.println(e);
				}
			}catch(Exception e) {
				System.err.println(e);
			}finally {
				try {
					System.out.println("receive ok");
					ois.close();
					s.close();
				}catch(Exception ee) {
					System.err.println(ee);
				}
			}//finally
		}//while
	}//receive
	
	public static void main(String [] args) {
		new EmpServer().receive();
	}
}

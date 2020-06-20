package emp;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
					Employee e = (Employee) ois.readObject();
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

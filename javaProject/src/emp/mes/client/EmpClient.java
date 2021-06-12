package emp.mes.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import emp.dto.EmpDTO;

public class EmpClient extends Thread{
	private List<EmpDTO> emps;
	private String ip = "localhost";
	private int port = 9000;
	
	public EmpClient(List<EmpDTO> emps) {
		this.emps = emps;
	}
	
	@Override
	public void run() {
		Socket s = null;
		ObjectOutputStream oos = null;
		
		try {
			s = new Socket(ip,port); // 클라 소켓 생성 
			
			oos = new ObjectOutputStream(s.getOutputStream()); // 클라 소켓으로 부터 스트림연결 
			
			for(EmpDTO e : emps) {
				oos.writeObject(e);
				oos.flush();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch(Exception e) {
			System.err.println(e);
		} finally {
			try {
				oos.close();
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			} 
		}
	}
}

package ref;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.net.Socket;
import java.io.IOException;


public class EchoClient {
	
	private String ip;
	private int port;
	private String str;
	private BufferedReader keybfr; //현재 키보드 입력용 
	
	public EchoClient(String ip,int port){
		this.ip = ip;
		this.port = port;
		
		// 소켓 생성하는 부분 분리 
		Socket client = getSocket();
		OutputStream os =null;
		InputStream is =null;
		
		keybfr = new BufferedReader(new InputStreamReader(System.in));
		
		//서버와의 출력용
		BufferedWriter bfw = null; 
			
		//서버에서 에코 날린거 읽기 --- 서버와의 연결용 
		BufferedReader bfr = null;
		
		
		try {
			
			 os = client.getOutputStream();
			 is = client.getInputStream(); 
			 System.out.println("입력하쇼 : ");
			 str = keybfr.readLine();
			 str +=System.getProperty("line.separator");
			 
			 bfw =  new BufferedWriter(new OutputStreamWriter(os));
			 bfr = new BufferedReader(new InputStreamReader(is));
			 
			 // 클라이언트가 키보드로 입력받은 것을 서버에게 전달
			 bfw.write(str);
			 bfw.flush();
			 
			 // 서버가 클라이언트가 전달한 내용을 다시 보낼경우 받는 작업 
			 str = bfr.readLine();
			 System.out.println("Echo Result : "+str);
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(keybfr!=null) {
				try {
					keybfr.close();
				}catch(IOException e) {}
			}
			if(os!=null) {
				try {
					os.close();
				}catch(IOException e) {}
			}
			if(is!=null) {
				try {
					keybfr.close();
				}catch(IOException e) {}
			}
			if(bfw!=null) {
				try {
					keybfr.close();
				}catch(IOException e) {}
			}
		}
		
	}
	
	public Socket getSocket() {
		Socket c = null;
		
		try {
			
			c = new Socket(ip,port);
			
		}catch(IOException e) {
			e.printStackTrace(); 
			System.exit(0); 
		}
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EchoClient("172.16.1.157",8123);
	}

}

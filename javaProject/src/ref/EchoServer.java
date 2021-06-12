package ref;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


import java.io.IOException;

//서버 
public class EchoServer {
	
	private BufferedReader bfr;
	private BufferedWriter bfw;
	private InputStream is;
	private OutputStream os;
	private ServerSocket serverSoc;
	
	public EchoServer(int port) {
		try {
			serverSoc = new ServerSocket(port);
		}catch(IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		while(true)
		{
			
			System.out.println("클라이언트 요청 대기중");
						
			try {
				//요청을 받아들여 데이터 통신을 위한 소켓 생성 
				Socket tclient = serverSoc.accept(); 
				
				System.out.println("클라이언트 ip주소 : "+ 
						tclient.getInetAddress().getHostAddress());
				
				//클라이언트와의 입력과 출력을 위한 연결 완성 
				is = tclient.getInputStream();
				os = tclient.getOutputStream();
				bfr = new BufferedReader(new InputStreamReader(is));
				bfw = new BufferedWriter(new OutputStreamWriter(os));
				
				String msg = bfr.readLine();
				System.out.println("수신메시지 : " + msg);
				
				//선을 추가하여 분리함
				msg+=System.getProperty("line.separator");
				
				//받은 메시지 다시 클라이언트에 전달
				bfw.write(msg);
				
				bfw.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(bfr!=null)
					try {
						bfr.close();
					}catch(IOException e) {
						
					}
				if(bfw!=null)
					try {
						bfw.close();
					}catch(IOException e) {
						
					}
				if(is!=null)
					try {
						is.close();
					}catch(IOException e) {
						
					}
				if(os!=null)
					try {
						os.close();
					}catch(IOException e) {
						
					}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EchoServer(8000);
	}

}

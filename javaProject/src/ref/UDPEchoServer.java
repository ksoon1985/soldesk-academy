package ref;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoServer {
	public UDPEchoServer(int port) {
		
		try {
			
			DatagramSocket dsocket = new DatagramSocket(port);
			
			while(true)
			{
				byte buffer[] = new byte[512];
				DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
				//데이터를 전송하는 단위 : packet(512 byte단위로 )
				
				System.out.println("준비");
				
				//클라이언트가 보내는 데이터를 패킷단위로 받겠다
				// receive 가 수행되면 데이터가 올 때 까지 프로세스를 정지하고 대기한다. 
				dsocket.receive(dp);
				
				String str = new String(dp.getData());
				System.out.println("수신 데이터 : " + str);
				
				// echo 작업중 
				InetAddress ia = dp. getAddress();
				port = dp.getPort();
				System.out.println("Client Ip : "+ia);
				System.out.println("Client Port : "+port);
				
				//                                                         client
				dp = new DatagramPacket(dp.getData(),dp.getData().length, ia, port);
				dsocket.send(dp);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPEchoServer(3000);
	}

}

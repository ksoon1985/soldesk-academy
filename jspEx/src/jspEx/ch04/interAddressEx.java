package jspEx.ch04;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class interAddressEx {
	public static void main(String[] args) throws UnknownHostException{
		// TODO Auto-generated method stub
		
		// InetAddress
		// IP 주소를 표현한 클래스 
		// 자바에선 모든 IP 주소를 InetAddress클래스를 사용 
		
		/*
		 	getLocalHost() : 사용하는 컴퓨터 네트워크 정보
		 	getHostName() : host 이름
		 	getHostAddress() : host ip주소 
		 	
		 	getByName() : host name 으로 부터 IP주소를 리턴 
		 */
		
		InetAddress iaddr = InetAddress.getLocalHost();
		System.out.println("호스트이름: " + iaddr.getHostName()); // DESKTOP-D1OKMEA
		System.out.println("호스트IP주소: "+ iaddr.getHostAddress()); // 172.16.1.97
		
		iaddr = InetAddress.getByName("www.google.co.kr");
		System.out.println("호스트이름: " + iaddr.getHostName()); // www.google.co.kr
		System.out.println("호스트IP주소: "+ iaddr.getHostAddress()); // 172.217.174.99
		
		iaddr = InetAddress.getByName("www.naver.com");
		System.out.println("호스트이름: " + iaddr.getHostName()); // www.naver.com
		System.out.println("호스트IP주소: "+ iaddr.getHostAddress()); // 125.209.222.142
		
		
	}
}

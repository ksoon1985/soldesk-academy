package javaEx.b.ch15;
import java.io.*;
import java.net.*;
import java.io.IOException;
import java.util.*;

public class MultiServer {

	private ArrayList<MultiServerThread> list;
	private Socket socket;
	private ServerSocket serverSocket;
	
//생성자
	public MultiServer() throws IOException {
		list = new ArrayList<MultiServerThread>(20);
		serverSocket = new ServerSocket(6000);
	
	MultiServerThread mst = null;		  	   //Thread 생성하기 위해 선언

	boolean isStop = false;					   //accept() 무한루프 일때 정지 가능하게 하게 하기위한 변수
	
		while(!isStop) {
			System.out.println("서버 대기중");	   //ServerSocket.accept()메소드로 클라이언트 접속 대기
											   //연결이 되면 socket 객체를 맴버로 할당
			socket = serverSocket.accept();
			
			mst = new MultiServerThread(this); //MultiServer 객체 인자로해서.
			list.add(mst);					   //Runable객체인 MultiServerThread 객체생성
			
			Thread t = new Thread(mst);		   // Thread 생성하고 시작
			t.start();			
		}
	}
	
// 연결된 클라이언트가 들어 있는 리스트 반환하기
	public ArrayList<MultiServerThread> getlist() {
		return list;
	}
	
// 클라이언트 소켓 반환하기
	public Socket getSocket() {
		return socket;
	}
	
	public static void main(String[] args) throws IOException {
		new MultiServer();
		
	}	
}

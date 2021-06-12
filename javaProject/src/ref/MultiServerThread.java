package ref;

import java.net.*;
import java.io.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class MultiServerThread implements Runnable{
	   //선언
	   private Socket socket;
	   private MultiServer ms;
	   private ObjectInputStream ois;
	   private ObjectOutputStream oos;
	   
	   //생성자
	   public MultiServerThread(MultiServer ms) {
	      this.ms = ms;
	   }
	   
	   public void run() {   
	      boolean isStop=false;
	      
	      //소켓 받고
	      socket = ms.getSocket();
	      //각 소켓에 입력과 출력 라인 받아와서
	      try {
	         ois = new ObjectInputStream(socket.getInputStream());
	         oos = new ObjectOutputStream(socket.getOutputStream());
	         String msg=null;
	         //입출력을 함 isStop의 거짓인동안
	         while(!isStop) {
	            msg = (String) ois.readObject();
	            String[] str = msg.split("#");
	            if(str[1].equals("exit")) {
	               //모두에게 알리고
	               broadCasting(msg);
	               //isStop을 true로 바꿈
	               isStop=true;
	            } else {
	               //모두에게 알리기
	               broadCasting(msg);
	               
	            }
	         }
	         //채팅이 종료 해당되는 클라이언트가와 연결된 스레드 종료
	         ms.getlist().remove(this);
	         System.out.println(socket.getInetAddress()+ "정상종료되었습니다.");
	         System.out.println("list Size:"+ ms.getlist().size());
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public void broadCasting(String msg) throws IOException {
	      for(MultiServerThread ct: ms.getlist()) {
	         ct.send(msg);
	      }
	   }

	   private void send(String msg) throws IOException {
	      oos.writeObject(msg);
	   }
	   
	   
	}


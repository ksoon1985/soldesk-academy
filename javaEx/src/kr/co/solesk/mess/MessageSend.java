package kr.co.solesk.mess;

public interface MessageSend {

	// 추상메소드 
	// 실제 클래스의 역활이 아니라 접속하는 창구 역활을 함
	// 추상메소드로만 이루어져 있음
	// 자바버전이 높아지면서 특별한 메소드를 일반메소드로 만들 수 있음
	public void sendMessage(String receiver, String content, String sender);
	
}

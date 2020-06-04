package kr.co.solesk.mess;

public class SMSSend implements MessageSend {

	@Override
	public void sendMessage(String receiver , String content, String sender) {
		// TODO Auto-generated method stub
		System.out.println("SMS 를 전송합니다. ");
		System.out.println("받는 사람 : " + receiver);
		System.out.println("내용 : " + content);
		System.out.println("받는 사람 : " + sender);
		
	}

}

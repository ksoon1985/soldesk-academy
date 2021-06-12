package kr.co.solesk.mess;

public class SendEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MessageSend m[] = {new SMSSend(), new EmailSend(), new FaxSend()};
		for(MessageSend mes : m)
		{
			if(mes instanceof SMSSend)
			{
				mes.sendMessage("010-555-3333", "SMS 다형성", "010-2222-3333");
			}
			else if(mes instanceof EmailSend)
			{
				mes.sendMessage("aaa@naver.com", "Email 다형성", "bbb@naver.com");	
			}
			else if(mes instanceof FaxSend)
			{
				mes.sendMessage("02-7788-8888", "Fax 다형성", "02-5445-1234");
			}
			else
			{
				
			}
		}
	}

}

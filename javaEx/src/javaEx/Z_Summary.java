package javaEx;

import java.math.BigDecimal;


public class Z_Summary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 기본형 ======================================================
		byte a = 100;// 1byte 
		short b = -500; // 2byte
		char c = '가'; // 2byte
		int d = 65555; // 4byte
		long e = 456123123l; // 8byte
		
		float f = 2866.8f; // 4byte
		double g = -345678.4567890; // 8byte
		
		// 돈과 소수점을 다룬다면 BigDecimal 은 필 수 ~ =======================
		BigDecimal v1 = new BigDecimal("0.7"); 
		BigDecimal v2 = new BigDecimal("0.1");
		BigDecimal result = v1.add(v2); System.out.println("BigDecimal : " + result);
		  
		//String ======================================================
		String str = "A";
		System.out.println((str +1+2).getClass() );// A12 string
		System.out.println((1+2+ str).getClass() );// 3A  string
		
		// heap 메모리 공간에 저장...
		// String str1 = "string pool 이라는 공간에 저장됨 ";
		// String str2 = new String("heap 영역 (string pool 가아닌) 공간에 저장이 됩니다.");
		// str1 == str2 : false -> 두변수의 reference가 다름
		// str1.equals(str2) : false -> 단순히 문자열이 같냐 다르냐 만 봄 
		// String str3 ="A";
		// String str4 ="B"; ->str3 , str4 똑같은 reference를 가리침 
		
		// 특수문자 처리     : string
		// 문자열 껴 넣을때 : string buffer
		// 전송할 때           : string builder
				
		// 참고 : https://jeong-pro.tistory.com/85
		// string , string buffer , string builder
		/*
		      위 세 클래스 모두 문자열을 저장하고 관리하는 클래스임.
		   
		*/
		//string buffer
		StringBuffer sf = new StringBuffer("안녕하세연");
		sf.append("hi");
		System.out.println(sf);
		
		sf.insert(0, "insert"); // 0번째 인덱스 
		System.out.println(sf);
		
		sf.delete(6, sf.length());
		System.out.println(sf);
		
		//string builder 
		StringBuilder sd = new StringBuilder("자바 공부 시작 했어요");
		sd.append(" 오늘");
		System.out.println(sd);
		int num1 = sd.indexOf("시작");
		System.out.println(num1);
		char num2 = sd.charAt(0);
		System.out.println(num2);
		
		//switch ======================================================
		int [] i = {1,2,3,4,5};
		for(int ii : i)
		{
			switch(ii) {
				case 1: System.out.println(ii);break;
				case 2: System.out.println(ii);break;
				case 3: System.out.println(ii);break;
				case 4: System.out.println(ii);break;
				case 5: System.out.println(ii);break;
				default : return; 
			}	
		}

		try {
			int n = Integer.parseInt(args[0]);
			
			switch(n) {
			case 1: System.out.println(n);break;
			case 2: System.out.println(n);break;
			case 3: System.out.println(n);break;
			case 4: System.out.println(n);break;
			case 5: System.out.println(n);break;
			default : System.out.println(n);
		}	
		}catch(NumberFormatException e1) {
			e1.printStackTrace();
		}
		
		//while ======================================================
		
		int k=1;
		while(k<=10)
		{
			System.out.print(k);
			k++;
		}
		System.out.println("");
		
		k = 1;
		do
		{
			System.out.print(k);
			k++;
		}while(k<=0); // do 는 조건 가기전에 실행부터 함 
	}
}

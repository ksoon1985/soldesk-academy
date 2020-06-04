package javaEx;

import java.math.BigDecimal;

public class InstanceEx extends A{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value = "가나다라마";
		boolean r = value instanceof String;
		System.out.println(r); // true
		Object v = value; // 업캐스팅
		String value2 = (String) v; //다운캐스팅 (표시해줘야함)
		r = value2 instanceof String;
		System.out.println(r);
		Object object = "가나다라";
		r = object instanceof BigDecimal;
		System.out.println(r);
		
		// A 는 ex 의 부모 클래스 
		InstanceEx ex = new InstanceEx();
		A a = new A();
		boolean r2 = ex instanceof A;
		//           자식                     부모 
		System.out.println(r2); // true
		
	}
}

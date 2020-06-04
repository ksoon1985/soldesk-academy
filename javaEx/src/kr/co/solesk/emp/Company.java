package kr.co.solesk.emp;

import javaEx.A;

public class Company {
	EmployeeP em;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 홍길동 사원 
		// 나일등 대리
		// 통신이 과장
		/*
		 * Employee em1 = new Employee(); // company 클래스에 em1 객체 (직원) em1.name = "홍길동";
		 * em1.position = "사원"; Employee em2 = new Employee(); em2.name = "나일등";
		 * em2.position = "대리"; Employee em3 = new Employee(); em3.name = "통신이";
		 * em3.position = "과장";
		 * 
		 * Employee [] emArray = new Employee[10]; emArray[0] = new Employee();
		 * emArray[0].name = "순환"; emArray[0].position ="부장"; emArray[0].clockIn();
		 * emArray[0].working(); emArray[0].clockOut();
		 */
		PartTime p1 = new PartTime();
		p1.setPart(6);
		p1.setName("알바몬");
		p1.setPosition("계약직");
		p1.clockIn();
		System.out.println(p1.getName() + "일급여 : "+p1.dayPay());
		
		PartTimeP pp1 = new PartTimeP("권","알바","010",5);
		pp1.clockIn();
		// 생성자 호출 시점
		// 부모 -> 자식 
	}

}

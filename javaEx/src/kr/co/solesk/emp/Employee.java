package kr.co.solesk.emp;

public class Employee {
	// 멤버 변수 : 이름, 직위 
	// 메소드 : 출근, 퇴근, 근무
	
	public String name;
	public String position;

	public void clockIn() {
		System.out.println(name + "님이(가) 출근했습니다.");
	}
	public void clockOut() {
		System.out.println(name + "님이(가) 퇴근했습니다.");
	}
	public void working() {
		System.out.println(name + "님이(가) 일하는 중입니다. ");
	}
	
}

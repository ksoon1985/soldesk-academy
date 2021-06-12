package kr.co.solesk.emp;

public class EmployeeP {  
	private String name;
	private String position;
	protected String tel;
	// overloading : 다형성 
	EmployeeP( ){} //생성자 // 메소드 들 의 함수의 이름은 (매개변수)
	EmployeeP(String name){}
	EmployeeP(String name, String position, String tel){
		System.out.println("EmployeeP 생성자 호출");
		this.name = name;
		this.position = position;
		this.tel = tel;

	}
	//get,setter
	public void setName(String name) {this.name = name;}
	public void setPosition(String position) {this.position = position;}
	public void setTel(String tel) {this.tel = tel;}
	
	public String getName() {return name;}
	public String getposition() {return position;}
	public String getTel() {return tel;}
	
	public void clockIn() {
		System.out.println(name + position +"님이(가) 출근했습니다.");
	}
	public void clockOut() {
		System.out.println(name + position +"님이(가) 퇴근했습니다.");
	}
	public void working() {
		System.out.println(name + position +"님이(가) 일하는 중입니다. ");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeP e1 = new EmployeeP("권","사원","010"); //객체(인스턴스) 화 
		e1.clockIn();
		e1.working();
		e1.clockOut();
		EmployeeP e2 = new EmployeeP();
		System.out.println(e2.getName()); // 널 
		
		e2.setName("권");
		e2.setPosition("사원");
		e2.clockIn();
		e2.working();
		e2.clockOut();
		
	}

}

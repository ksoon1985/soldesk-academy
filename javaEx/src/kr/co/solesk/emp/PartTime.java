package kr.co.solesk.emp;

public class PartTime extends EmployeeP {
//상속(extends) 
	//시프트 part(5) 시간
	int timePay = 8590; // 13,000 
	private int part;
	public void setPart(int part) {this.part = part;}
	public int getPart() {return part;}
	public int dayPay() {return timePay * part;}
}

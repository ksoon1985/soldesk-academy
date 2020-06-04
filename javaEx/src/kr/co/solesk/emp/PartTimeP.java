package kr.co.solesk.emp;

public class PartTimeP extends EmployeeP {
	private int timePay = 8590;
	private int part;
	PartTimeP(){}
	PartTimeP(String name, String position, String tel,int part){
		// 까먹은 포인트!!! 
		super(name,position,tel);//부모 생성자 호출 
		System.out.println("PartTimeP 생성자 호출 ");	
/*		
 * 		super.setName(name);
		super.setPosition(position);
		super.tel = tel;
*/
		this.part = part;
	}
	
	public int getPart() {return part;}
	public void setPart(int part) {this.part = part;}
	public int dayPay() {return timePay*part;}
}

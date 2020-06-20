package emp;

import java.io.Serializable;

// Serializable 직렬화 
/*
	자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 
	외부의 자바 시스템에서도 사용할 수 있도록 바이트(byte) 형태로 데이터 변환하는 기술과
	 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)을 아울러서 이야기합니다.
	 
	 참고 : https://woowabros.github.io/experience/2017/10/17/java-serialize.html
	      https://woowabros.github.io/experience/2017/10/17/java-serialize2.html
*/
public class Employee implements Serializable {
	private int empNo;
	private String name;
	private String position;
	private String dept;
	
	public Employee() {}
	public Employee(int empNo, String name, String position, String dept) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.position = position;
		this.dept = dept;
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(empNo);
		builder.append(" ");
		builder.append(name);
		builder.append(" ");
		builder.append(position);
		builder.append(" ");
		builder.append(dept);
		
		return builder.toString();	
	}
	
}

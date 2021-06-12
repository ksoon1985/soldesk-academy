package ExTest2;

public class A {
	protected int number;
	protected String name; 
	private int age;
	A(){
		System.out.println("A생성자 호출 ");
	}
	A(int number, String name , int age){
		System.out.println("A생성자 호출 ");
		this.number = number;
		this.name = name;
		this.age = age;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

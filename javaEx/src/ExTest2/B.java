package ExTest2;

public class B extends A{
	B(){
		System.out.println("B생성자 호출 ");
	}
	/*
	B(int number , String name){
		System.out.println("B생성자 호출 ");
		super.number = number;
		super.name = name;
	}
	*/
	B(int number , String name , int age){
		super(number,name,age);
		System.out.println("B생성자 호출 ");
	}
	public static void main(String [] args) {
		B b1 = new B();
		B b2 = new B(10102424,"ㄱㅅㅎ",123);
		b1.setName("ㄱㅅㅎ");
		b1.setNumber(27);
		System.out.println(b1.getName());
		System.out.println(b1.getNumber());
	}
}

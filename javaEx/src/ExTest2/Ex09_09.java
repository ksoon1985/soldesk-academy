package ExTest2;

public class Ex09_09 {
	static int a = 100;
	static void func1() {
		int a = 200;
		System.out.println(a);
	}
	
	public static void main(String [] args) {
		Ex09_09.func1();
		System.out.println(Ex09_09.a);
	}
}

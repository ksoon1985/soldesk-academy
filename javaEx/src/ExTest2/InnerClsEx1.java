package ExTest2;

public class InnerClsEx1 {
	public static void main(String [] args) {
		Outer o = new Outer();
		//
		Outer.Inner i = o.new Inner(); // 내부클래스 객체 인스턴스화...
		
		System.out.println(o.getOa());
		System.out.println(i.getIa());
		
		
	}
}

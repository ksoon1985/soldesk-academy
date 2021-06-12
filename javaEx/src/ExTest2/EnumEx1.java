package ExTest2;

public class EnumEx1 {
	public enum Lesson{ JAVA,XML,EJB }
	/*
		특수한 Lesson 이라는 내부 클래스 
	  	메소드 존재 가능 
	  	객체 : JAVA, XML , EJB 
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lesson le = Lesson.JAVA;
		System.out.println("Lesson : " + le);
		System.out.println("XML : " + Lesson.XML);
	}

}

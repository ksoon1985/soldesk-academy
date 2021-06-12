package javaEx;

public class ReferenceEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// == 참조(reference)변수만 비교 
		boolean r1 = new Integer("1") == new Integer("1");
		boolean r2 = new Integer(1) == new Integer(1);
		
		System.out.println(r1); // false
		System.out.println(r2); // false
		System.out.println((new Integer("1")).equals(new Integer("1")) );// true
		System.out.println((new Integer("1")).compareTo(new Integer("1")) ); // 0 -> true 
		System.out.println((new Integer("1")).compareTo(new Integer("2")) ); // -1 -> 오른쪽이 더 크다  
		System.out.println((new Integer("2")).compareTo(new Integer("1")) ); // 1 -> 왼쪽이 더 크다  
		
		
	}

}

package ExTest2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import static java.lang.System.out;

public class GenerEx1 {
	public static void main(String [] args) {
		
		// 컬렉션 collection : 자료구조
		// 제너릭 generic    : collection에 들어갈 타입을 설정하는 것 
		
		/*
		ArrayList<String> a1 = new ArrayList<String>();
		
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		
		a1.add("20");
		a1.add("10");
		
		a2.add(1);
		*/
		
		/*
		String[] str = {"Java","Beans","Java","XML"};
	      
		HashSet<String> hs1 = new HashSet<String>();
		HashSet<String> hs2 = new HashSet<String>();
		for (String n : str){
          if (!hs1.add(n))
              hs2.add(n);
		}
		out.println("hs1 : " + hs1);
		hs1.removeAll(hs2);  
		out.println("hs1 : " + hs1);
		out.println("hs2 : " + hs2);
		*/
		
		String[] groupA = {"홍길동","김길동","이길동","독고길동"};
		 
		Stack<String> stack = new Stack<String>(); 
		for(String n : groupA) 
			stack.push(n); 

		while(!stack.isEmpty()) 
			out.println(stack.pop()); // 독고길동 이길동 김길동 홍길동
	}
	
	
}

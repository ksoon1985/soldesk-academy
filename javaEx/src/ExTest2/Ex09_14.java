package ExTest2;

import java.util.Scanner;

public class Ex09_14 {
	
	static int calc(int v1, int v2,String op)
	{
		int result;
		
		switch(op)
		{
		case "+": result = v1 + v2; break;
		case "-": result = v1 - v2; break;
		case "*": result = v1 * v2; break;
		case "/": result = v1/v2  ; break;
		default : result = 0;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int res;
		String oper;
		int a,b;
		
		System.out.println("oper (+,-,*,/ 중 입력) : ");
		oper = s.next();
		
	}

}

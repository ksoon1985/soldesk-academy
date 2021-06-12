package ExTest2;
import java.util.Scanner;

public class Ex14_07 {
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		char[] stack = new char[5];
		int top = 0;
		
		char carName = 'A';
		int select = 9;
		
		while(select !=3)
		{
			System.out.println("<1>자동차 넣기 <2> 자동차 빼기 <3> 끝 : ");
			select = s.nextInt();
			
			switch(select) {
			case 1:
				if(top >5) {System.out.println("stack overflow"); break;}
			}
		}
		
	}
}

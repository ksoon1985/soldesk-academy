package ExTest2;

import java.util.Scanner;

public class Ex08_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int []aa = new int[5];
		int hap = 0;
		
		for(int i=0;i<5;i++)
		{
			System.out.printf((i+1) +"번째 값 입력 : ");
			aa[i] = s.nextInt();
			
			System.out.printf(aa[i] + "값을 삽입했습니다. \n");
		}
		
		for(int i=0;i<aa.length;i++)
			hap += aa[i];
		
		System.out.println("aa배열의 총 합계 : " + hap );
		
		
	}

}

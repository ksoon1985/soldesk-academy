package ExTest2;

import java.util.Scanner;

public class Ex04_03 {
	public static void main(String [] args)
	{
		for(int i = 1; i<10;i++) {
			for(int j=2;j<10;j++) {
				System.out.printf("%d x %d = %d \t",j,i,j*i);
			}
			System.out.println("");
		}
	}
}

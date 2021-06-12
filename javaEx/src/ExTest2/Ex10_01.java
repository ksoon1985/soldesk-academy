package ExTest2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex10_01 {

	public static void main(String[] args) // throws IOException 
	{
		// TODO Auto-generated method stub
		/*
		int a = 100, b=0;
		int result;
		try {
			if(b==0)
			{
				throw new Exception("0으로 나누려고요? 안되지 ..");
			}
			result = a/b;
		}catch(Exception e) {
			System.out.println("발생 오류");
			System.out.println(e.getMessage());
		}
		*/
		
		/*
		String userName = "hanbit";
		String input = "";
		int key;
		
		try {
			System.out.print("이름 ==> ");
			while ((key = System.in.read()) != 97) {
				System.out.println(key+"를 입력 받았습니다. ");
				input += Character.toString((char)key);
			}
			if (userName.equals(input))
				System.out.println(input + "님 어서오세요 ~~");
			else
				System.out.println(input + "님 등록이 안되었습니다 ~~");
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		*/
		
		/*
		FileInputStream fis ;
		int ch;
		
		try {
			fis = new FileInputStream("C:\\Users\\soldesk\\Desktop\\data1.txt");
			while((ch = fis.read()) != -1)
			{
				System.out.print((char)ch);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		*/
		
		
		/*
		FileReader fReader = null;
		BufferedReader bReader = null;
		String str = null;
		
		try {
			//fReader = new FileReader("c:\\Windows\\win.ini");
			fReader = new FileReader("c:/Windows/win.ini");
			bReader = new BufferedReader(fReader);
			
			while((str = bReader.readLine()) != null)
			{
				System.out.println(str);
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			fReader.close();
			bReader.close();
		}
		
		Scanner sc = new Scanner(new File("C:/Users/soldesk/Desktop/data2.txt"));
		int hap = 0;

		while (sc.hasNextLine())
			hap += sc.nextInt();

		System.out.println("합계 : " + hap);
		sc.close();
		*/
		
		// 13
		/*
		FileOutputStream fos = new FileOutputStream("C:/Users/soldesk/Desktop/data2.txt");
		int ch;
		while((ch = System.in.read()) != 13)
			fos.write((byte)ch);
		
		fos.close();
		*/
		
		//14
		/*
		Scanner sc = new Scanner(System.in);
		
		FileWriter fw = null;
		
		try{ 
			fw= new FileWriter("C:/Users/soldesk/Desktop/data2.txt");
			String str;
		
		while(!(str = sc.nextLine()).equals(""))
			fw.write(str + "\r\n");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		
		// 15
		/*
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("c:/Windows/win.ini");
			fos = new FileOutputStream("C:/Users/soldesk/Desktop/data2.txt");
			
			int ch;
			
			while((ch = fis.read())!= -1 )
				fos.write((byte)ch);
			
			System.out.println("복사완료");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 */
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(args[0]);
			fos = new FileOutputStream(args[1]);
			
			int ch;
			
			while((ch = fis.read())!= -1 )
				fos.write((byte)ch);
			
			System.out.println("복사완료");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

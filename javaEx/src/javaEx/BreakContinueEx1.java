package javaEx;

public class BreakContinueEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<11;i++)
		{
			if(i==6)break;
			
			System.out.println("i="+i);
		}
		System.out.println("********************************");
		for(int i=1;i<=25;i++)
		{
			System.out.print(i+"\t");
			if(i%5==0) System.out.println("");
		}
		System.out.println("********************************");
		int c=0;
		//lable:
		for(int i=1;i<6;i++)
		{
			for(int j=1;j<6;j++)
			{
				c++;
				if(c%5==0) break;
				System.out.printf("%3d",c);
			}
			System.out.println("");
		}
		
		String stringValue = "가나다라마";
		char[] chars = stringValue.toCharArray();
		for(char charValue : chars)
		{
			System.out.print(stringValue.indexOf(charValue)+
					":"+charValue + "\n");
		}
		System.out.println("********************************");

		String s[][]= {{"강아지","고양이","말","원숭이"},{"개","냥이","말","원뚱이"}};
		for(String[] ss : s)
		{
			for(String sss : ss)
			{
				System.out.println(sss); // 강 ~ 원뚱이 출력 
			}
		}
	}
}

package ExTest2;
// 스레드 의 목적 : 상황에 따라 빨리 처리하게 하는것 이 목적 
public class MultiThread implements Runnable{
	public void run() {
		int first = 0;
		int second = 0;
		for(int i=0;i<5;i++)
		{
			first++;
			second++;
			System.out.printf("first : %d, ",first);
			System.out.printf("second : %d, ",second);
			System.out.printf("스레드 이름 : %s \n", Thread.currentThread().getName());		
			
		}
	}
	
	public static void main(String [] args) {
		MultiThread str1 = new MultiThread();
		Thread firstThread = new Thread(str1,"첫번째 스레드");
		MultiThread str2 = new MultiThread();
		Thread secondThread = new Thread(str2,"두번쨰 스레드");
		
		secondThread.start();
		firstThread.start();
		
	}
}

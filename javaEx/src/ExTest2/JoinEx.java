package ExTest2;

public class JoinEx {
	public static void main(String [] args) {
		System.out.println(
			Thread.currentThread().getName() + " start");
			// main thread 
		
		Runnable r = new MyRunnableTwo();
		Thread myThread = new Thread(r);
		myThread.start();
		
		// join을 호출한 메서드(main 메서드) 를 myThread 가 끝날 때 까지 
		// try 문에서 기다림 
		
		try {
			myThread.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println(
				Thread.currentThread().getName()+" end");
	}
}

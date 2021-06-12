package ExTest2;

public class PriorityChangeEx extends SuperThreadPriority{
	public PriorityChangeEx(String threadName) {
		super(threadName);
	}
	
	public static void main(String [] args) {
		Thread t1 = new SuperThreadPriority("첫번째 스레드");
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		
		Thread t2 = new SuperThreadPriority("두번째 스레드");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		
		//첫번째 스레드가 슥 먼저 처리해 버려서 
		// 출력이 첫번쨰 스레드가 먼저 나옴 
	}
}

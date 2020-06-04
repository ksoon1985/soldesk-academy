package ExTest2;

public class MyRunnableTwo implements Runnable{
	public void run() 
	{
		System.out.println(Thread.currentThread().getName() );
		System.out.println("run");
		first();
	}
	public void first()
	{
		System.out.println("first");
		second();
	}
	public void second()
	{
		System.out.println("second");
	}
	
}

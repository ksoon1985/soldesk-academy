package ExTest2;

public class ATMTwo implements Runnable{
	private long depositeMoney = 10000;
	
	public void run() {
		Thread.State state = Thread.currentThread().getState();
		System.out.println(this);
		
		synchronized(this) { // 임계영역  
			for(int i=0;i<10;i++)
			{
				if(getDepositeMoney() <=0 ) break;
				
				withDraw(1000);//
				
				if(getDepositeMoney() == 4000 ||
					getDepositeMoney() == 6000 ||
					getDepositeMoney() == 8000) {
					
					try {
						this.wait(); //일시정지 시킴 
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					this.notify();
					//일시 정지 상태에 있는 다르 스레드를 실행 대기 상태로 만듬 
				}
			}
		} //임계영역 끝 
	}
	
	public void withDraw(long howMuch) {
		if(getDepositeMoney() > 0 ) {
			depositeMoney -= howMuch;
			System.out.print(Thread.currentThread().getName() + " , ");
			System.out.printf("잔액 : %,d원  \n",getDepositeMoney());
		}else {
			System.out.print(Thread.currentThread().getName() + " , ");
			System.out.println("잔액이 부족합니다. ");
		}
	}
	
	public long getDepositeMoney() {
		return depositeMoney;
	}
}

package ExTest2;

public class Ex14_08 {
	static class Car extends Thread{
		String carName;
		Car(String carName){this.carName = carName;}
		
		public void run() {
			for(int i=0;i<3;i++)
			{
				try {
					Thread.sleep(10);
					System.out.println(carName + "~~달립니다.");
				}catch(Exception e) {
					
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car("자동차1");
		c1.start();
		
		
	}

}

package ExTest2;

public class Ex14_09 {

	static class Car{
		String carName;
		
	}
	
	static class Truck extends Car implements Runnable{
		Truck(String carName){super.carName = carName;}
		
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
		Truck car1 = new Truck("트럭1");
		Thread truck1 = new Thread(car1);
		truck1.start();
		
		Truck car2 = new Truck("트럭2");
		Thread truck2 = new Thread(car2);
		truck2.start();
		
	}

}

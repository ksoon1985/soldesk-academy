package ExTest2;

class Car {
	private String color;
	private int speed;
	
	void upSpeed(int value)
	{
		if(speed + value > 200)
		{
			speed = 200;
		}
		else
		{
			speed+= value;
		}
	}
	void downSpeed(int value)
	{
		if(speed - value < 0)
		{
			speed = 0;
		}
		else
		{
			speed -= value;
		}
	}
	
	public String getColor() {return color;}
	public int getSpeed() {return speed;}
	public void setColor(String color) {this.color = color;}
	public void setSpeed(int speed) {this.speed = speed;}
	
}

public class Ex11_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Car myCar1 = new Car();
		myCar1.color = "빨강";
		myCar1.speed = 0;
		
		Car myCar2 = new Car();
		myCar2.color = "파랑";
		myCar2.speed = 0;
		
		Car myCar3 = new Car();
		myCar3.color = "노랑";
		myCar3.speed = 0;
		
		myCar1.upSpeed(30);
		System.out.println(myCar1.color + myCar1.speed);
		
		myCar2.upSpeed(60);
		System.out.println(myCar2.color + myCar2.speed);
		
		myCar3.upSpeed(90);
		System.out.println(myCar3.color + myCar3.speed);
		
		myCar1.downSpeed(20);
		myCar2.downSpeed(30);
		myCar3.downSpeed(50);
		*/
		Car myCar1 = new Car();
		myCar1.setColor("빨강");
		myCar1.setSpeed(50);
		
		System.out.println("색깔:"+ myCar1.getColor() + "   "+
				"스피드:"+myCar1.getSpeed());
		
		myCar1.upSpeed(200);
		System.out.println("색깔:"+ myCar1.getColor() + "   "+
				"스피드:"+myCar1.getSpeed());
		myCar1.downSpeed(250);
		System.out.println("색깔:"+ myCar1.getColor() + "   "+
				"스피드:"+myCar1.getSpeed());
		
		
	}

}

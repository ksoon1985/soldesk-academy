package ExTest2;

class Car2{
	private String color;
	private int speed;
	
	Car2(){}
	Car2(String color){this.color = color;}
	Car2(String color, int speed){this.color = color; this.speed = speed;}
	
	public String getColor() {return color;}
	public int getSpeed() {return speed;}
	public void setColor(String color) {this.color = color;}
	public void setSpeed(int speed) {this.speed = speed;}
}

public class Ex11_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car2 myCar1 = new Car2();
		Car2 myCar2 = new Car2("빨강");
		Car2 myCar3 = new Car2("파랑",30);
		
		System.out.println(myCar1.getColor() + " " + myCar1.getSpeed());
		System.out.println(myCar2.getColor() + " " + myCar2.getSpeed());
		System.out.println(myCar3.getColor() + " " + myCar3.getSpeed());	
	}
}

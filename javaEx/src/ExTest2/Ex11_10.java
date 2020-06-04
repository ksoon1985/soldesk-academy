package ExTest2;

class Car3{
	String color;
	int speed;
	private static int count = 0;
	private final static int maxNum = 100;
	Car3(){
		if(count < maxNum)
		{
			count++;
		}
	}
	
	public static int getCount() { return count;}
}

public class Ex11_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car3 myCar = new Car3();
		//System.out.println(myCar.count);
		
		Car3 myCar2 = new Car3();
		System.out.println(Car3.getCount());
		
		
		
		
	}

}

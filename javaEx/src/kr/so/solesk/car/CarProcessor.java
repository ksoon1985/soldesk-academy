package kr.so.solesk.car;

public class CarProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DumpTruck dt1 = new DumpTruck(2000,8,4,"빨간색","덤프트럭");
		System.out.println(dt1.getCC());
		System.out.println(dt1.getWheelNum());
		System.out.println(dt1.getDoorNum());
		System.out.println(dt1.getColor());
		System.out.println(dt1.getTruckType());
		
		// 매개변수를 1, 2, 3, 4 , 5라고 하면
		// DumpTruck(1, 2, 3, 4 , 5)생성자 호출 
		// -> Truck(1, 2, 3, 4 , 5) 생성자 호출
		// -> Car(1, 2, 3, 4) 생성자 호출
		// 생성자에서 super로 접근하기 때문에 
		// 출력문은 Car -> Truck -> DumpTruck 순으로 출력되는것임.
		
		Car c[] = {new Sedan(), new Sedan(), new Sedan(), new DumpTruck() };
		for(Car i : c)
		{
			if( i instanceof Sedan)
			{
				System.out.println("세단 입니다.");
				System.out.println(i);
			}
			else if(i instanceof DumpTruck)
			{
				System.out.println("덤프 트럭입니다.");
				System.out.println(i);
			}
		}
		
	} 

}

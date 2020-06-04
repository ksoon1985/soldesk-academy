package kr.so.solesk.car;

public class Sedan extends Car {
	public Sedan(){}
	Sedan(int carCC, int carWheelNum, int carDoorNum,String carColor)
	{
		super(carCC,carWheelNum,carDoorNum,carColor);
		System.out.println("Cedan 생성자 호출 ");
	}
	
	@Override 
	public void startCar() {
		// TODO Auto-generated method stub
		System.out.println("세단 시동을 걸다 ");
	}

	@Override
	public void stopCar() {
		// TODO Auto-generated method stub
		System.out.println("세단 시동을 끄다 ");
	}

	@Override
	public void driveCar() {
		// TODO Auto-generated method stub
		System.out.println("세단 전진을 한다 ");
	}

	@Override
	public void redriveCar() {
		// TODO Auto-generated method stub
		System.out.println("세단 후진을 한다.");
	}

}

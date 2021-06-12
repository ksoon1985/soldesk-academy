package kr.so.solesk.car;

public class DumpTruck extends Truck {
	
	public DumpTruck(){}
	DumpTruck(int carCC,int carWheelNum,int carDoorNum,String carColor,String truckType)
	{	
		super(carCC, carWheelNum, carDoorNum, carColor,truckType);
		System.out.println("DumpTruck 생성자 호출 ");
	}

	
	@Override
	public void startCar() {
		// TODO Auto-generated method stub
		System.out.println("덤프트럭 시동을 걸다 ");
	}

	@Override
	public void stopCar() {
		// TODO Auto-generated method stub
		System.out.println("덤프트럭 시동을 걸다 ");
	}

	@Override
	public void driveCar() {
		// TODO Auto-generated method stub
		System.out.println("덤프트럭 시동을 걸다 ");
	}

	@Override
	public void redriveCar() {
		// TODO Auto-generated method stub
		System.out.println("덤프트럭 시동을 걸다 ");
	}

}

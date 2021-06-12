package kr.so.solesk.car;

public class Truck extends Car {
	private String truckType;
	Truck(){
		System.out.println("Truck 생성자 호출 ");
	}
	Truck(String truckType){
		this.truckType = truckType;
		System.out.println("Truck 생성자 호출 ");
	}
	Truck(int carCC, int carWheelNum, int carDoorNum,String carColor,String truckType)
	{
		super(carCC,carWheelNum,carDoorNum,carColor);
		this.truckType = truckType;
		System.out.println("Truck 생성자 호출 ");
	}
	public String getTruckType() {return truckType;}
	
	@Override
	public void startCar() {
		// TODO Auto-generated method stub
		System.out.println("트럭 시동을 걸다 ");
	}

	@Override
	public void stopCar() {
		// TODO Auto-generated method stub
		System.out.println("트럭 시동을 걸다 ");
	}

	@Override
	public void driveCar() {
		// TODO Auto-generated method stub
		System.out.println("트럭 시동을 걸다 ");
	}

	@Override
	public void redriveCar() {
		// TODO Auto-generated method stub
		System.out.println("트럭 시동을 걸다 ");
	}

}

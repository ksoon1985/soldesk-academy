package kr.so.solesk.car;

//추상클래스 ( ~ 의 한 종류 라는 의미 )
//추상메소드 하나이상 갖고 있음
//멤버 필드, 생성자 가질 수 있음 
//일반 메소드도 있을 수 있음
//인스턴스화(객체화) 가 안됨. -> 상속을 위한 클래스 
//추상메소드는 하위메소드에서 반드시 구현을 해 줘야 한다. 
public abstract class Car {
	protected int carCC;
	protected int carWheelNum;
	protected int carDoorNum;
	protected String carColor;
	
	Car(){System.out.println("Car 생성자 호출 ");}
	Car(int carCC,int carWheelNum,int carDoorNum,String carColor){
		System.out.println("Car 생성자 호출 ");
		this.carCC = carCC;
		this.carWheelNum = carWheelNum;
		this.carDoorNum = carDoorNum;
		this.carColor = carColor;
	}
	
	// get,setter (단축기 : alt + shift + s)
	public int getWheelNum() {return carWheelNum;}
	public int getDoorNum() {return carDoorNum;}
	public String getColor() {return carColor;}
	public int getCC() {return carCC;}
	public void setWheelNum(int carWheelNum) {this.carWheelNum = carWheelNum;}
	public void setDoorNum(int carDoorNum) {this.carDoorNum = carDoorNum;}
	public void setColor(String carColor) {this.carColor = carColor;}
	public void setCC(int carCC) {this.carCC = carCC;}
	public abstract void startCar();
	public abstract void stopCar();
	public abstract void driveCar();
	public abstract void redriveCar();
	
}

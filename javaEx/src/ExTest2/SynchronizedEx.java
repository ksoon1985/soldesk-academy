package ExTest2;

public class SynchronizedEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ATM atm = new ATM();
		Thread mother = new Thread(atm,"mother");
		Thread son = new Thread(atm,"son");
		son.start();
		mother.start();
		*/
		ATMTwo atm = new ATMTwo();
		Thread mother = new Thread(atm,"mother");
		Thread son = new Thread(atm,"son");
		son.start();
		mother.start();
	}

}

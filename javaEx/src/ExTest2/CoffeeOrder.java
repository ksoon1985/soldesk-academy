package ExTest2;

public class CoffeeOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 연한 커피만으로 주문1
		// 보통 커피만으로 주문2
		// 진한 커피만으로 주문3
		
		// 연한 커피 , 설텅만으로 주문 1,1
		// 보통 커피 , 설텅만으로 주문 2,2
		// 진한 커피 , 설텅만으로 주문 3,3
		
		// 연한 커피 , 설텅만으로 주문 1,1,1
		// 보통 커피 , 설텅만으로 주문 2,2,2
		// 진한 커피 , 설텅만으로 주문 3,3,3
		
		CoffeeMake cm = new CoffeeMake(2,2,2);
		
		cm.makeCoffee(1);
		cm.makeCoffee(2);
		cm.makeCoffee(3);
		
		cm.makeCoffee(1, 1);
		cm.makeCoffee(2, 2);
		cm.makeCoffee(3, 3);
		
		cm.makeCoffee(1,1,1);
		cm.makeCoffee(2,2,2);
		cm.makeCoffee(3,3,3);
		
	}

}

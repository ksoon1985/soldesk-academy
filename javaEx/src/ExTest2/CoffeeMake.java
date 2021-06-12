package ExTest2;

public class CoffeeMake {
	
	private int coffee = 1;
	private int sugar = 1;
	private int cream = 1;
	
	CoffeeMake(){}
	CoffeeMake(int coffee ,int sugar, int cream){
		this.coffee = coffee;
		this.sugar = sugar;
		this.cream = cream;
	}
	
	public int getCoffee() {return this.coffee;}
	public int getSugar() {return this.sugar;}
	public int getCream() {return this.cream;}
	
	public void setCoffee(int coffee) {this.coffee = coffee;}
	public void setSugar(int sugar) {this.sugar = sugar;}
	public void setCream(int cream) {this.cream = cream;}
	
	public void makeCoffee(int coffee) 
	{
		this.coffee = coffee;
		System.out.println("coffee : " + coffee );
		System.out.println("coffee 만 들어있는 coffee를 만듭니다. ");
	}
	
	public void makeCoffee(int coffee,int sugar) 
	{
		this.coffee = coffee;
		this.sugar = sugar;
		System.out.println("coffee : " + coffee );
		System.out.println("sugar : " + sugar );
		System.out.println("coffee & sugar 들어있는 coffee를 만듭니다. ");
	}
	
	public void makeCoffee(int coffee,int sugar,int cream) 
	{
		this.coffee = coffee;
		this.sugar = sugar;
		this.cream = cream;
		System.out.println("coffee : " + coffee );
		System.out.println("sugar : " + sugar );
		System.out.println("cream : " + cream );
		System.out.println("coffee & sugar & cream이 들어있는 coffee를 만듭니다. ");
	}
}

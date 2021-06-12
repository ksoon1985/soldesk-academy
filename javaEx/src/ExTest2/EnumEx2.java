package ExTest2;

public class EnumEx2 {
	public enum Item{ // class 처럼 생성이 됨 
		Add,Del,Search,Cancel
	}
	
	public static void main(String[] args) {
		Item a1 = Item.Search;
		if(a1 instanceof Object) { // 열거형인지 객체형인지 비교 
			System.out.println(a1.toString());
			System.out.println("ok! instanceof object");
			System.out.println("저장될 실제 정수 값 : " + a1.ordinal()); // 지정된 정수 값 
		}
		
		Item [] items = Item.values(); // Item.values()는 열거형
		System.out.println("item.length : " +items.length); //4 
		
		for(Item n : items)
			System.out.println(n+":"+n.ordinal());
	}
}

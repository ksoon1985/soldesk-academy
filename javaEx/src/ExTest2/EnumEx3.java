package ExTest2;

public class EnumEx3 {
	public enum Item
	{
		Add(5), Del(11), Search(2) , Cancel(22);
		// Item 이 Add , Del , Search , Cancel 임 
		
		private final int var; // 값이 없으므로 한번 할당 가능  
		
		Item(int v){var = v;} // 내부 생성자 처럼  ex) Add(5) -> 5값이 var 로 할당 
		
		public int getVar() {return var;} // 메소드 선언 
	}
	
	public static void main(String [] args) {
		for(Item n : Item.values())
		{
			System.out.println(n + " : " + n.getVar());  // 5 , 11 , 2 , 22
			System.out.println(n + " : " + n.ordinal()); // 0 , 1  , 2 , 3 
		}
	}
}

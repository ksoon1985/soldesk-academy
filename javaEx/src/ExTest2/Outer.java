package ExTest2;

public class Outer {
	int oa= 20;
	
	//멤버형태의  내부 클래스
	class Inner{
		int ia = 10;
		public int getIa() {
			return ia;
		}
	}
	
	public int getOa() {
		return oa;
	}
}

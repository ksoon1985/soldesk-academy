package ExTest2;

public class InterEx implements Inter5 {
	int data = 100;
	
	@Override
	public int meth3() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public int meth2() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int meth1() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int meth4() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int printData() {
		// TODO Auto-generated method stub
		return VALUE;
	}
	
	// 재정의 불가 
	public final int interMethod() {
		return 300;
	}

}

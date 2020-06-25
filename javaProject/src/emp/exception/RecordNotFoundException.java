package emp.exception;

public class RecordNotFoundException extends Exception{
	@Override
	public String toString() {
		return super.toString() + ": 데이터가 없습니다.";
	}
}

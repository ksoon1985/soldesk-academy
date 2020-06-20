package emp;

import java.util.List;

public interface IEmpMgr {
	public void load(String filename); // filename에서 객체를 읽어들이는 메소드
	public void save(String filename); // filename에 객체를 쓰는 메소드
	public void add(Employee e) throws DuplicateException; //Employee 저장 메서드
	public List<Employee> search(); //전체 직원 정보 리턴 메소드
	public Employee search(int num) throws RecordNotFoundException; // 검색된 직원 리턴 메소드
	public void update(Employee b) throws RecordNotFoundException; // 직원 수정 메소드
	public void delete(int num) throws RecordNotFoundException;
}

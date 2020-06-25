package emp.mgr.impl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import emp.dto.EmpDTO;
import emp.exception.DuplicateException;
import emp.exception.RecordNotFoundException;
import emp.mgr.IEmpMgr;

public class EmpMgrImpl implements IEmpMgr {

	private List<EmpDTO> emps;
	private static EmpMgrImpl instance; // singleton 디자인 패턴 
	
	private EmpMgrImpl() {
		emps = new ArrayList<EmpDTO>();
		load("emp.dat");
	}
	
	public static EmpMgrImpl getInstance() {
		if(instance == null)
			instance = new EmpMgrImpl();
		
		return instance;
	}
	
	// 파일로 자료를 읽어서 메모리(ArrayList)에 저장
	@Override
	public void load(String filename) {
		// TODO Auto-generated method stub
		
		File file = new File(filename);
		System.out.println(file);
		
		if(!file.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			return;
		}
		
		emps.clear(); // list 를 null 로 초기화 하고 size 를 0으로 설정 
		
		ObjectInputStream ois = null;
		Object ob = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			while(true)
			{
				ob = ois.readObject();
				emps.add((EmpDTO)ob);
			}
		} catch (EOFException e) {
			System.out.println("읽기 완료.");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch(IOException e) {
			System.out.println(e);
		} catch(ClassNotFoundException e) {
			System.out.println("같은 클래스 타입이 아닙니다. ");
		} finally {
			if(ois != null) {
				try {
					ois.close();
				}catch(IOException e) {
					System.out.println("파일을 닫는데 실패했습니다.");
				}
			}
		}// finally
	}// load

	@Override
	public void save(String filename) {
		// TODO Auto-generated method stub
		
		File file = new File(filename);
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			for(EmpDTO e : emps)
			{
				oos.writeObject(e);
				oos.flush(); // 버퍼의 내용을 강제로 출력하여 비움 
			}
			
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch(IOException e) {
			System.err.println(e);
		} finally {
			try {
				oos.close();
			}catch(IOException e) {
				System.err.println(e);
			}
		}
	}//save

	@Override
	public void add(EmpDTO b) throws DuplicateException {
		// TODO Auto-generated method stub
		
		for(EmpDTO e : emps)
		{
			if(e.getEmpNo() == b.getEmpNo())
			{
				throw new DuplicateException();
			}
		}
		
		emps.add(b);
	}

	@Override
	public EmpDTO search(int num) throws RecordNotFoundException {
		// TODO Auto-generated method stub

		for(EmpDTO e : emps)
		{
			if(e.getEmpNo() == num)
			{
				return e;
			}
				
		}
		
		throw new RecordNotFoundException();
		
	}

	@Override
	public void update(EmpDTO b) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
		boolean chk = true;
		
		for(EmpDTO e : emps)
		{
			if(e.getEmpNo() == b.getEmpNo()) {
				e.setName(b.getName());
				e.setPosition(b.getPosition());
				e.setDept(b.getDept());
				chk = false;
				break;
			}
		}
		
		if(chk) {
			throw new RecordNotFoundException();
		} 
	}

	@Override
	public void delete(int num) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
		EmpDTO e = search(num);
		emps.remove(e);
	}

	@Override
	public List<EmpDTO> search() {
		// TODO Auto-generated method stub

		return emps;
	}

}

package javaEx;

import kr.so.solesk.car.Car;
import kr.so.solesk.car.DumpTruck;
import kr.so.solesk.car.Sedan;

import java.util.ArrayList;
import java.util.List;

public class GenericsEx1 {
	public static void main(String[] args) {
		// 객체를 여러개 담아서 사용가능한 타입 (List(interface) )
		// List 를 구현한 ArrayList
		
		List<Object> a1 = new ArrayList<Object>();
		a1.add("사과");
		a1.add(200);
		a1.add("포도");
		a1.add("300");
		a1.add(new Integer(100));
		
		for(int i=0 ; i<a1.size();i++)
		{
			if(a1.get(i) instanceof String)
			{
				System.out.println(a1.get(i).getClass());
				String s = (String)a1.get(i);
				System.out.println(s);
			}
			else
			{
				System.out.println(a1.get(i).getClass());
				int num = (Integer)a1.get(i);
				System.out.println(num);
			}
		}
		
		List<Car> a3 = new ArrayList<Car>();
		a3.add(new Sedan());
		a3.add(new DumpTruck());
		// 실행 for DumpTruck 아니면 시동걸고 전진
		// 덤프면 시동걸고 dumpOut
		for(Car c : a3)
		{
			if(c instanceof DumpTruck)
			{
				c.driveCar(); // 오버라이딩 car-> truck -> dumptruck
			}
			else if(c instanceof Sedan)
			{
				c.driveCar(); // 오버라이딩 car -> sedan
			}
		}
		
		Object o1 = new Integer(100);
	}
}

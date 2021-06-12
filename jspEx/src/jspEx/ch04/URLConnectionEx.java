package jspEx.ch04;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLConnectionEx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// url 정보를 담을 URL 객체 생성   ... https -> ssl exception 
		URL url = new URL("http://docs.oracle.com/javase/8/docs/api/");
		
		// url에서 페이지 정보를 가져오기 위해 URLConnection 사용  즉 , 페이지 정보다 
		URLConnection urlCon = url.openConnection();
		
		// connect() : 네트워크 상의 다른 곳과 연결 해줄때 사용 
		urlCon.connect();
		Map<String,List<String>> map = urlCon.getHeaderFields();
		
		// java collection 이란
		/*
		  	Map , List 는 Interface
		  	Map 을 구현하고 있는 구현체 , 많이 쓰는 것 HashMap
		  	List 를 구현하고 있는 구현체 , ArrayList
		  	Map 은 key 와 value 형태로 이루어져 있고 
		   	해당하는 value를 가져오는 자료구조
		    List는 순차적으로 해당되는 인덱스에 위치한 객체를 갖고오는 자료구조
		        자료구조
		    key = List<String> 형태로 가져옴  
		*/
		
		Set<String> s = map.keySet();
		Iterator<String> iter = s.iterator();
		while(iter.hasNext())
		{
			String name = iter.next();
			System.out.print(name + " : ");
			List<String> value = map.get(name);
			for(String v : value)
			{
				System.out.print(v + "\t");
			}
			System.out.println();
		}
		// Set
		/*
		 	Set interface 로 구현체는 순서가 없음
		 	순서를 부여하고 값을 처리하는데 유용  -> iterator 
	    */
		
		int len = urlCon.getContentLength();
		System.out.println("문서길이 : " + len + "바이트");
		if(len > 0)
		{
			InputStream input = urlCon.getInputStream();
			int readByte;
			System.out.println("==========문서내용==========");
			while((readByte = input.read())!=-1 && (--len>0) )
			{
				System.out.print((char)readByte);
				
			}
			
			input.close();
		}//if close
		else
		{
			System.out.println("ㄴㅐ 용 없 음 ");
		}
		
	}// main close
}

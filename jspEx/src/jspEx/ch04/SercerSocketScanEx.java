package jspEx.ch04;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.*;

public class SercerSocketScanEx extends JFrame implements ActionListener,Runnable{

	private JButton jbt_scan; 					// 버튼
	private JTextField jtp_ip;					// 텍스트필드
	private JList<Object> jlistRts;				// 리스트, 콤보박스 아님 
	private JLabel jlbIp;						// 라벨 
	private DefaultListModel<Object> lmodel;	// 리스트 디폴트 모델 
	private int index;
	private String ip;
	/*
	 	DefaultListModel : 스윙은 컴포넌트에 데이터를 추가 혹은 삭제하기 위해서 모델이 따로 준비되어 있어야함
	 	만일 프로그래머가 직접 모델 클래스 를 설계하지 않더라도 각 컴포넌트 마다 디폴트 모델이 준비되어 있기 때문에
	 	이를 컴포넌트의 모델로 사용 할 수 있다. 
	 	예를 들어 버튼인 경우 DefaultButtonModel
	 	모델이 리스트인 경우엔 DefaultListModel
	 	-> 이렇게 얻어진 모델 객체로 내용을 변경하기 위한 다양한 작업이 가능함. 
	 	
	 	출처 : https://m.blog.naver.com/PostView.nhn?blogId=heoguni&logNo=130170350764&proxyReferer=https:%2F%2Fwww.google.com%2F
	 */
	
	//생성자 
	public SercerSocketScanEx(String msg) {
		super(msg); //msg값이 JFrame title 로 들어감 
		
		jbt_scan = new JButton("서버스캔"); 				// 버튼 생성 
		
		lmodel = new DefaultListModel<Object>();  		// 디폴트 모델 생성 
		jlistRts = new JList<Object>(lmodel);			// 리스트 에 디폴트 모델 넣어줌 
		
		jlistRts.setVisibleRowCount(10);				// 리스트 한번에 (크기) 10줄씩 출력
		
		JPanel jp = new JPanel();						// 패널 생성 하고 버튼 붙이기 
		jp.add(jbt_scan);
		
		jbt_scan.addActionListener(this);				// (JFrame)에서  버튼에 액션 리스너를 걸어줌 
		
		JScrollPane jsp = new JScrollPane(jlistRts); 	// 리스트를 부착한 스크롤팬 생성 
		
		add(jsp,BorderLayout.CENTER);					// (JFrame)에 팬을 부착
		add(jp,BorderLayout.SOUTH);						// (JFrame)에 패널을 부착 
		
		pack();											// 컨테이너의 크기를 구성 요소들의 크기로 설정 
		setVisible(true);	
		addWindowListener(new WindowAdapter(){			// (JFrame)에 WindowListener를 걸어줌  
			public void windowClosing(WindowEvent we)	// 나가면 exit 되게 
			{
				System.exit(0);
			}
		});
	}
	
	public void actionPerformed(ActionEvent ae) {		// jbt_scan 버튼을 눌렀을 때 
		Object obj = ae.getSource(); 					// 액션을 일으킨 컴포넌트 받아옴 
		if(obj == jbt_scan)
		{
			lmodel.insertElementAt(ip,index);			// index위치에 ip 삽입 
			jlistRts.setSelectedIndex(index);			// 표시될 인덱스 값이 설정 
			index++;
			Thread t = new Thread(this);
			t.start();
		} 
	}
	
	public void run() {
		ServerSocket s = null;
		for(int i =1;i<100;i++)
		{
			try {
				// 내 IP가 서버가 되고 포트번호로 생성 ... 
				s = new ServerSocket(i);
				System.out.println(s.getLocalPort());
				
			}catch(IOException e) {
				lmodel.insertElementAt(i+"번 포트가 사용중입니다. ",index);
				jlistRts.setSelectedIndex(index);
			}
			
			lmodel.insertElementAt("서버스캔 종료 ", index);
			jlistRts.setSelectedIndex(index);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame.setDefaultLookAndFeelDecorated(false); //보여지는 창의 차이 
		
		new SercerSocketScanEx("ServerSocket Scanner");
	}

}

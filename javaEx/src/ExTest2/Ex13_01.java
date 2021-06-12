package ExTest2;

import javax.swing.JFrame;

public class Ex13_01 {
	static class MyGUI extends JFrame {
		MyGUI() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("GUI 연습");

			// 이 부분에 버튼, 레이블, 체크박스 등을 코딩함

			setSize(500, 500);
			setVisible(true);
		}
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyGUI();
	}
}
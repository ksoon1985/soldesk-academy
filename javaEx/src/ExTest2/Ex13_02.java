package ExTest2;

import java.awt.*;
import javax.swing.*;

public class Ex13_02 {

	static class MyGui2 extends JFrame{
		MyGui2(){
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("연습");
			
			//this.setLayout(new FlowLayout());
			this.setLayout(new BorderLayout(10,10));
			
			JButton btn1 = new JButton("버튼1");
			//this.add(btn1);
			this.add(btn1,BorderLayout.NORTH);
			
			JButton btn2 = new JButton("버튼2");
			//this.add(btn2);
			this.add(btn2,BorderLayout.WEST);
			
			JButton btn3 = new JButton("버튼3");
			//this.add(btn3);
			this.add(btn3,BorderLayout.CENTER);
			
			JButton btn4 = new JButton("버튼4");
			//this.add(btn4);
			this.add(btn4,BorderLayout.EAST);
			
			JButton btn5 = new JButton("버튼5");
			//this.add(btn5);
			this.add(btn4,BorderLayout.SOUTH);
			
			this.setSize(256,256);
			this.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyGui2();
	}

}

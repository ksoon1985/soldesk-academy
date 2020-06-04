package ExTest2;
import java.awt.*;
import javax.swing.*;

public class Ex13_06 {
	static class MyGUI3 extends JFrame{
		MyGUI3(){
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("d");
			this.setLayout(null);
			
			JButton btn1 = new JButton("버튼1");
			btn1.setBounds(50,50,70,60);
			this.add(btn1);
			
			JButton btn2 = new JButton("버튼2");
			btn2.setBounds(110,110,70,60);
			this.add(btn2);
			
			this.setSize(256, 256);
			this.setVisible(true);
		}
	}
	public static void main(String [] args)
	{
		new MyGUI3();
	}
}

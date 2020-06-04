package ExTest2;

import java.awt.*;
import javax.swing.*;

public class Ex13_09 {
	static class MyGUI extends JFrame{
		
		MyGUI(){
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("d");
			
			Container c = this.getContentPane();
			
			c.setLayout(new FlowLayout());
			
			JTextField txt1 = new JTextField(10); //10 : 가로(글자수)
			c.add(txt1);
			
			JTextArea txt2 = new JTextArea(5,10); // textarea 생성 , (5,10)크기
			//c.add(txt2);	// 팬에 부착
			c.add(new JScrollPane(txt2)); //
			
			JPasswordField txt3 = new JPasswordField(10);
			c.add(txt3);
			
			this.setSize(200,200);
			this.setVisible(true);
		}
	}
	public static void main(String [] args) {
		new MyGUI();
	}
}

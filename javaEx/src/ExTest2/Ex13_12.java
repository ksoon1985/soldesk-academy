package ExTest2;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ex13_12 {
	static class MyGUI extends JFrame{
		MyGUI(){
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("adf");
			this.setLayout(new FlowLayout());
			
			JTextField txt = new JTextField(10);
			JTextArea area = new JTextArea(10,10);
			
			this.add(txt);
			this.add(area);
			
			txt.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e)
				{
					int key = e.getKeyCode();
					
					if(key == KeyEvent.VK_ENTER) {
						String str = txt.getText();
						area.setText(area.getText() + str + '\n');
						txt.setText("");
					}
					
					if(!(key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9)) {
						int strlen = txt.getText().length();
						
						if(strlen != 0)
							txt.setText(txt.getText().substring(0,strlen));
						
					}
				}
			});
		}
	}
}

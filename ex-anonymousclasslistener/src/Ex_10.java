import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex_10 extends JFrame{
	public Ex_10() {
		setTitle("더블클릭 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.addMouseListener(new MyListener());
		
		JButton btn = new JButton("버튼");
		btn.addMouseListener(new MybtnListener());
		btn.setSize(300,50);
		btn.setLocation(100,100);
		c.add(btn);
	}
	
	class MyListener extends MouseAdapter{
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					Component c = (Component)e.getSource();
					int r = (int)(Math.random()*256);
					int g = (int)(Math.random()*256);
					int b = (int)(Math.random()*256);
					c.setBackground(new Color(r,g,b));
				}
			}
	}
	
	class MybtnListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2) {
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("버튼")) {
					b.setText("버튼이 눌렸습니다.");					
				}else {
					b.setText("버튼");
				}	
				
			}
		}
	}
	
	public static void main(String[] args) {
		new Ex_10();
	}
}
	

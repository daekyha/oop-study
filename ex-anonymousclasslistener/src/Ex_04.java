import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex_04 extends JFrame {
	private JLabel la = new JLabel("Hello");
	
	Ex_04(){
		setTitle("예제 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				la.setLocation(x,y);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {	}
			@Override
			public void mouseExited(MouseEvent e) {}	
		});
		
		c.setLayout(null);
		la.setSize(30,30);
		la.setLocation(30,30);
		c.add(la);
		
		JButton btn = new JButton("버튼");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				//JButton e 
			}
	
		});;
		c.add(btn);
		
		setSize(300,300);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new Ex_04();
	}
}

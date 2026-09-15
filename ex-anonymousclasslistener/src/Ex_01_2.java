
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex_01_2 extends JFrame{
	public Ex_01_2() {
		setTitle("예제 1 - 이벤트 리스너 구현");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("버튼 1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				
					if(b.getText().equals("버튼 1")) {
						b.setText("버튼 2");
					}else {
						b.setText("버튼 1");
					}
				}
			});
		c.add(btn1);
		
		JButton btn2 = new JButton("버튼 A");
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				
				if(b.getText().equals("버튼 A")) {
					b.setText("버튼 B");
				}else {
					b.setText("버튼 A");
				}
			};
		});
		c.add(btn2);
		
		
		setSize(315,150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex_01();
	}
}

//class Myaction_Listener1 implements ActionListener{
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton b = (JButton)e.getSource();
//		
//		if(b.getText().equals("버튼 1")) {
//			b.setText("버튼 2");
//		}else {
//			b.setText("버튼 1");
//		}
//	};
////}
//
//class Myaction_Listener2 implements ActionListener{
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton b = (JButton)e.getSource();
//		
//		if(b.getText().equals("버튼 A")) {
//			b.setText("버튼 B");
//		}else {
//			b.setText("버튼 A");
//		}
//	};
//}



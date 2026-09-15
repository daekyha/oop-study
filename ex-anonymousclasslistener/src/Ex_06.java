import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex_06 extends JFrame {
	JLabel[] keyMessage = new JLabel[3];

	public Ex_06() {
		setTitle("예제 6번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKeyListener());

		keyMessage[0] = new JLabel("1번 라벨");
		keyMessage[1] = new JLabel("2번 라벨");
		keyMessage[2] = new JLabel("3번 라벨");

		for (int i = 0; i < keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.YELLOW);
		}

		c.setFocusable(true);
		c.requestFocus();

		setSize(500, 500);
		setVisible(true);
	}

	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keycode = e.getKeyCode();
			char keychar = e.getKeyChar();
			keyMessage[0].setText(Integer.toString(keycode));
			keyMessage[1].setText(Character.toString(keychar));
			keyMessage[2].setText(e.getKeyText(keycode));
		}
	}

	public static void main(String[] args) {
		new Ex_06();		
	}

}
/*
 * int w = getWidth(); int h = getHeight();
 * 
 * 
 * 
 */
//*S/
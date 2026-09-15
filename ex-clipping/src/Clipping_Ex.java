import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.security.auth.kerberos.KerberosTicket;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Clipping_Ex extends JFrame{
	
	public Clipping_Ex() {
		setTitle("클리핑 써보기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new MyJPanel());
		
		setVisible(true);
		setSize(1000,1000);
	}
	
	public static void main(String[] args) {
		new Clipping_Ex();
	}

}

class MyJPanel extends JPanel{
	private ImageIcon icon= new ImageIcon("images/pic1.jpg");
	private Image img = icon.getImage();
	int h=100, w=20;
	
	Graphics g;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setClip(h,w,50,50);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);	
	}
	
	
	class Mykey_L extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyChar()) {
				case KeyEvent.VK_UP: {
					h+=10;
					break;
				}
				case KeyEvent.VK_DOWN: {
					h-=10;
					break;
				}
				case KeyEvent.VK_LEFT: {
					w-=10;
					break;
				}
				case KeyEvent.VK_RIGHT: {
					w+=10;
					break;
				}
			}
			repaint();
		}
			
	}
	
}





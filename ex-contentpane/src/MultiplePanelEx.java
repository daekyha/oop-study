import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MultiplePanelEx extends JFrame{
	public MultiplePanelEx() {
		super ("test 타이틀");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new WestPanel(), BorderLayout.WEST);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
	}
	
	class NorthPanel extends JPanel{
		public NorthPanel() {
			setBackground(Color.LIGHT_GRAY);
			setLayout(new FlowLayout());
			add(new JButton("Open"));
			add(new JButton("Read"));
			add(new JButton("Close"));
		}
	}
	class WestPanel extends JPanel{
		public WestPanel() {
			setBackground(Color.LIGHT_GRAY);
			setLayout(new FlowLayout());
			add(new Label("봄"));
			add(new Label("여름"));
			add(new Label("가을"));
			add(new Label("겨울"));
			
		}
	}

	class CenterPanel extends JPanel{
		private JLabel [] labels = { new JLabel("Hello"), new JLabel("Java"), new JLabel("Love")};
		public CenterPanel() {
			setLayout(null);
			for(int i =0; i<labels.length; i++) {
				int x= (int)(Math.random()*200);
				int y= (int)(Math.random()*200);
				labels[i].setLocation(x, y); // 랜덤한 위치에 JLabel 배치
				labels[i].setSize(100,20); // JLabel의 크기 지정
				add(labels[i]); // JLabel을 이 패널(CenterPanel)에 부착				
			}			
		}		
	}
	
	static public void main(String[] arg) {
		new MultiplePanelEx();
	}
}

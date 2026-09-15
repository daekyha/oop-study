import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBox_Ex extends JFrame{
	public CheckBox_Ex() {
		setTitle("예제11-4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon cherry_icon = new ImageIcon("images/cherry.jpg");
		ImageIcon apple_icon = new ImageIcon("images/apple.jpg");
		
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배", true);
		JCheckBox cherry = new JCheckBox("체리", apple_icon);
		
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(cherry_icon);
		
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
	}
	
	public static void main(String[] args) {
		new CheckBox_Ex();
	}
}

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPanEx extends JFrame{
	public ContentPanEx() {
		setTitle("프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 4,10)); 
		//contentPane.setLayout(new BorderLayout()); 
		//contentPane.setLayout(new GridBagLayout()); 
		//contentPane.setLayout(new CardLayout()); 
		
		contentPane.add(new JButton("OK")); 
		contentPane.add(new JButton("Cancel")); 
		contentPane.add(new JButton("Ignore")); 
		
		setSize(300, 150); 
		setVisible(true); 
	}
	
	public static void main(String[] args) {
		new ContentPanEx();
	}

}

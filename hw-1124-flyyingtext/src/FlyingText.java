import java.awt.Component;
import java.awt.Container;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlyingText extends JFrame{
	private final int UNIT = 10;					// 이동 기본 단위. 
	private final int WHITE_SPACE = 30;			// 여백 크기 지정.
	private JLabel la = new JLabel("Hello");		// 이동 텍스트.
	private int height;							// 창 height
	private int width;							// 창 width
	
	public FlyingText() {
		setTitle("Ex_08 이동제한 구현하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		
		// 문자열 초기 위치 및 사이즈 설정. 
		la.setLocation(100,100);
		la.setSize(100,20);
		
		//Container 설정 및 리스너 추가.
		Container c = getContentPane();
		c.setLayout(null);
		c.add(la);
		c.addKeyListener(new MyKeyListener());	
		c.addComponentListener(new MyComponentAdapter());
		height = c.getHeight();
		width = c.getWidth();
		
		// Focus 관련 설정.
		c.setFocusable(true);
		c.requestFocus();
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component com =(Component)e.getSource();
				com.setFocusable(true);
				com.requestFocus();	
			}
		});
		
	}
	//=========================================================================================//
	// 컴포넌트 크기 변경시 이벤트 리스너
	class MyComponentAdapter extends ComponentAdapter {
		public void componentResized(ComponentEvent e) {
			Container c = (Container)e.getSource(); 
			width = c.getWidth();
			height = c.getHeight();
			la.setLocation(limit_w(la.getX()), limit_h(la.getY()));
			// 창 크기가 변화할때 텍스트가 밖에 있을 수 있으므로 변화시마다 위치범위 검사.
		}
	}
	
	//=========================================================================================//
	// 키 눌릴때 이벤트 리스너
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
				case KeyEvent.VK_UP:			// 상
					la.setLocation(la.getX(), limit_h(la.getY()-UNIT));
					break;
				case KeyEvent.VK_DOWN:		// 하
					la.setLocation(la.getX(), limit_h(la.getY()+UNIT));
					break;
				case KeyEvent.VK_LEFT:		// 좌
					la.setLocation(limit_w(la.getX()-UNIT), la.getY());
					break;
				case KeyEvent.VK_RIGHT:		// 우
					la.setLocation(limit_w(la.getX()+UNIT), la.getY());
					break;
			
			}
		}
	}
	//=========================================================================================//
	// 변화값이 이동범위 내에 위치하면 변화값을, 벗어나면 최소/최대값를 리턴.	
	// 이동범위는 여백을 제외한 WHITE_SPACE ~ (max_w/h  - WHITE_SPACE)으로 규정함.
	public int limit_w(int w_in) {
		if(WHITE_SPACE > w_in) {						// 최소값 미만
			return WHITE_SPACE;
		}
		else if(w_in > width-WHITE_SPACE) {			// 최대값 초과
			return width-WHITE_SPACE;			
		}
		else {
			return w_in;
		}
		
	}
	public int limit_h(int h_in) {
		if(WHITE_SPACE > h_in) {						// 최소값 미만
			return WHITE_SPACE;
		}
		else if(h_in > height-WHITE_SPACE) {			// 최대값 초과
			return height-WHITE_SPACE;			
		}
		else {
			return h_in;
		}
	}
	//=========================================================================================//
	public static void main(String[] args) {
		new FlyingText();
	}
}

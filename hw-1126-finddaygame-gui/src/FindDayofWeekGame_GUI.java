
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FindDayofWeekGame_GUI extends JFrame{
	// 이미지 레이블 생성
	//private ImageIcon solarpng = new ImageIcon("images/solar.png");
	//private ImageIcon lunarpng = new ImageIcon("images/lunar.png");

	Container c = getContentPane();
	
	final int user_max = 5;
	Calendar cal = Calendar.getInstance();
	KoreanLunarCalendar luncal = KoreanLunarCalendar.getInstance();
	User[] user = new User[user_max];
	
	// [1] 상단 패널
	String[] calendar_type_string = {"양력", "음력"};
	int calendar_type = 0;
	ButtonGroup calendar_group = new ButtonGroup();
	JRadioButton solar = new JRadioButton(calendar_type_string[0],true);
	JRadioButton lunar = new JRadioButton(calendar_type_string[1]);

	// [2] 좌측 패널
	String[] mod_string = {"[1] 년, 월, 일 모두 랜덤", "[2] 년, 월 랜덤 (일 선택)"
			, "[3] 년 랜덤 (월, 일 선택)", "[4] 모두 선택"};
	JList<String> mod_list = new JList<String>(mod_string);


	// [3] 중앙 패널
	JTextField year_text = new JTextField(Integer.toString(cal.get(Calendar.YEAR)) ,20);
	JTextField month_text = new JTextField(Integer.toString(cal.get(Calendar.MONTH) + 1),20);
	JTextField dayOfMonth_text = new JTextField(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)),20);
	String[] dayOfWeek_string = {"월요일","화요일","수요일","목요일","금요일","토요일","일요일"};
	JList<String> dayOfWeek_list = new JList<String>(dayOfWeek_string);
	
	// [4] 우측 패널
	JTextField id_textbox = new JTextField(20);
	JCheckBox new_check = new JCheckBox("신규");
	JButton login_btn = new JButton("로그인");
	JLabel print = new JLabel();

	// [5] 하단 패널
	JButton calculate = new JButton("결과 확인하기");
	JLabel score_label = new JLabel("총점");
	JLabel score_text = new JLabel("0점");
	JLabel rank_label = new JLabel("순위");
	JLabel rank_text = new JLabel("0위");
	JLabel winrate_label = new JLabel("승률");
	JLabel winrate_text = new JLabel("0.0");
	JLabel total_label = new JLabel("총원");
	JLabel total_text = new JLabel("0명");
	
	// [6] 프로그램 동작 관련
	String id;
	String dayOfWeek_answer;
	String dayOfWeek_input = "월요일";			// 사용자 입력
	int dayOfWeek_index;
	int year_input = cal.get(Calendar.YEAR);		// 초기값 - 현재 날짜
	int month_input = cal.get(Calendar.MONTH) +1;		// 초기값 - 현재 날짜
	int day_input = cal.get(Calendar.DAY_OF_MONTH);	// 초기값 - 현재 날짜
	int year_set, month_set, day_set;			// 시스템에 들어갈 입력(랜덤요소 포함)
	int maxDay;
	int mod=4;						// 모드 - 기본값 : 4
	
	boolean newlogin=false;					// 신규 체크 여부 확인 
	boolean login_state=false;				// 로그인 여부 확인
	int find_index;							

	//=======================================================================//
	// 클래스 생성자
	public FindDayofWeekGame_GUI() {
		setTitle("요일 맞추기 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		c.setLayout(new BorderLayout(30,20));
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new WestPanel(), BorderLayout.WEST);
		c.add(new EastPanel(), BorderLayout.EAST);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		setSize(1000,500);
		setVisible(true);
	}
	//=======================================================================//
	// 패널 관련 클래스
	// 1. 북쪽 패널
	class NorthPanel extends JPanel{
		public NorthPanel() {
			setLayout(new FlowLayout(FlowLayout.CENTER,30,40));
			MyCalendartype_L listener= new MyCalendartype_L();
			solar.addItemListener(listener);
			lunar.addItemListener(listener);
			solar.setBorderPainted(true);
			lunar.setBorderPainted(true);
			
			calendar_group.add(solar);
			calendar_group.add(lunar);
			add(solar);
			add(lunar);
		}
	}

	//2. 중앙 패널
	class CenterPanel extends JPanel{
		public CenterPanel() {
			setLayout(new GridLayout(4,2,5,5));
			year_text.addActionListener(new MyYeartextbox_L()); 
			month_text.addActionListener(new MyMonthtextbox_L()); 
			dayOfMonth_text.addActionListener(new MyDaytextbox_L()); 
			
			dayOfWeek_list.setVisibleRowCount(3);
			dayOfWeek_list.setFixedCellHeight(20);
			dayOfWeek_list.setFixedCellWidth(100);
			dayOfWeek_list.addListSelectionListener(new MydayOfWeeklist_L());
			
			add(new JLabel("연도"));
			add(year_text);
			add(new JLabel("월"));
			add(month_text);
			add(new JLabel("일"));
			add(dayOfMonth_text);
			add(new JLabel("요일"));
			add(new JScrollPane(dayOfWeek_list));
			
		}
	}
	
	//3. 서쪽 패널
	class WestPanel extends JPanel{
		public WestPanel() {
			//setLayout(new FlowLayout(FlowLayout.CENTER,5,70));
			setLayout(new GridLayout(4,1,5,5));
			add(new JLabel("모드 선택"));
			mod_list.setVisibleRowCount(2);
			mod_list.setFixedCellHeight(20);
			mod_list.setFixedCellWidth(200);
			mod_list.addListSelectionListener(new MyModlist_L());
			add(new JScrollPane(mod_list));
			
		}
	}
	
	//4. 동쪽 페널
	class EastPanel extends JPanel{
		public EastPanel() {
			setLayout(new GridLayout(5,1,3,5));
			id_textbox.addActionListener(new MyIdtextbox_L());
			new_check.addItemListener(new MyNewlogin_L());
			login_btn.addActionListener(new MyLogin_L());
		
			add(new JLabel("계정명"));
			add(id_textbox);
			add(new_check);
			add(login_btn);
			add(print);
			
			
		}
	}

	// 5. 하단 패널
	class SouthPanel extends JPanel{
		public SouthPanel() {
			setLayout(new FlowLayout(FlowLayout.CENTER, 30,50));
			add(score_label);
			add(score_text);
			add(winrate_label);
			add(winrate_text);
			add(rank_label);
			add(rank_text);
			add(total_label);
			add(total_text);
			
			score_label.setFont(new Font("고딕체", Font.ITALIC,20));
			score_text.setFont(new Font("고딕체", Font.ITALIC,20));
			winrate_label.setFont(new Font("고딕체", Font.ITALIC,20));
			winrate_text.setFont(new Font("고딕체", Font.ITALIC,20));
			rank_label.setFont(new Font("고딕체", Font.ITALIC,20));
			rank_text.setFont(new Font("고딕체", Font.ITALIC,20));
			total_label.setFont(new Font("고딕체", Font.ITALIC,20));
			total_text.setFont(new Font("고딕체", Font.ITALIC,20));
			
			add(calculate);
			calculate.addActionListener(new MyCalbtn_L());
		}
	}

	//=======================================================================================//
	// 리스너 클래스.
	// 1. 양력 / 음력 구별 체크박스
	class MyCalendartype_L implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.DESELECTED) return;
			else if(solar.isSelected()) {
				System.out.println("양력이 선택됨.");
				calendar_type = 0;
			}
			else if(lunar.isSelected()) {
				System.out.println("음력이 선택됨.");
				calendar_type = 1;
			}
			
		}
	}
	//2. 계정명 텍스트 박스 리스너
		class MyIdtextbox_L implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				id= id_textbox.getText();
				System.out.println("id :" + id +"가 정상적으로 입력됨.");
			}
		}
		
		//3. 신규 체크박스 리스너
		class MyNewlogin_L implements ItemListener{
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("신규 체크박스 활성화.");
					if(User.count>=5) {
						print.setText("계정 생성 한도");
						new_check.setSelected(false);
					}else {
						print.setText("생성할 계정 이름을 입력하세요.");
						login_btn.setText("가입");
						newlogin =true;		// 신규 가입 여부 활성화.
					}
				}else {
					System.out.println("신규 체크박스 비활성화.");
					newlogin =false;
					login_btn.setText("로그인");
					
				}
			}
		}

		//4. 로그인 버튼 리스너
		class MyLogin_L implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				boolean find=false;
				JButton btn = (JButton)e.getSource();
				if(btn.getText().equals("로그아웃")) {
					// 로그아웃된 경우
					login_btn.setText("로그인");
					login_state = false;
					// 점수 초기화.
					score_text.setText("0점");
					winrate_text.setText("0%");
					rank_text.setText("0위");
					print.setText("로그아웃되었습니다.");
					new_check.setEnabled(true);
				}else {

					// 로그인할 경우
					if(newlogin) {
						try {
							if(User.checkId(user, id)) {
								// id 중복 여부 체크
								print.setText("이미 존재하는 계정입니다.");
							}else {
								// 계정 추가 과정.
								user[User.count] = new User(id.trim());
								User.count++;
								total_text.setText(User.count+"명");
								print.setText("가입되었습니다. 다시 로그인하세요.");
								System.out.println("계정 추가됨.");
								new_check.setSelected(false);
								newlogin=false;
								login_btn.setText("로그인");
							}
								
						}catch (Exception ex) {
							print.setText("잘못된 계정이름입니다.");
						}
					}else {
						// 계정명과 동일한 인덱스가 있는지 확인.
						for(int i = 0; i< User.count; i++) {
							if (user[i].getID().equals(id.trim())) {
								find = true;
								find_index = i;
								break;
							}
						}	
						// 확인과정에서 찾지 못하면 로그인 x, 찾으면 login
						if(find == false) {
							print.setText("등록되지 않는 계정입니다.");
						}else {
							//로그인 성공
							login_state = true;
							System.out.println("id : " + id + " 로그인 됨.");
							login_btn.setText("로그아웃");
							print.setText("플레이 할 게임을 선택하세요.");
							new_check.setEnabled(false);

							
							//로그인 되면 현재 정보를 불러옴.
							score_text.setText(user[find_index].getTotal()+"점");
							winrate_text.setText(user[find_index].calWinRate()+"%");
							rank_text.setText(user[find_index].calRank(user)+"위");
						}
					
					}
				}
				
			}
		}

		// 5. 연도 입력 텍스트 박스 리스너
		class MyYeartextbox_L implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				year_input= Integer.parseInt(t.getText());
				System.out.println("연도 : "+year_input+"가 정상적으로 입력됨.");
			}
		}
		
		// 6. 월 입력 텍스트 박스 리스너
		class MyMonthtextbox_L implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				month_input= Integer.parseInt(t.getText());
				System.out.println("월 : "+month_input+"이 정상적으로 입력됨.");
			}
		}
		
		// 7. 일 입력 텍스트 박스 리스너
		class MyDaytextbox_L implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				day_input= Integer.parseInt(t.getText());
				System.out.println("일 : "+day_input+"이 정상적으로 입력됨.");
			}
		}

		
		// 8. 요일 입력 리스트 리스너
		class MydayOfWeeklist_L implements ListSelectionListener{
			public void valueChanged(ListSelectionEvent e) {
				dayOfWeek_input= dayOfWeek_list.getSelectedValue();
			}
		}
		
		// 9. 모드 리스트 리스너
		class MyModlist_L implements ListSelectionListener{
			public void valueChanged(ListSelectionEvent e) {
				String modlist=mod_list.getSelectedValue();
				if(!login_state) {
					print.setText("로그인이 필요합니다.");
				}else {
					for(int i=0;i<4;i++) {
						if(modlist.equals(mod_string[i])) {
							mod = i+1;
						}
					}
					
					switch (mod) {
						case 1: {
							print.setText("모드 :1번이 선택됨.");
							year_text.setEditable(false);
							year_text.setText("[ 랜덤 선택 ]");
							month_text.setEditable(false);
							month_text.setText("[ 랜덤 선택 ]");
							dayOfMonth_text.setEditable(false);
							dayOfMonth_text.setText("[ 랜덤 선택 ]");
							break;
						}
						case 2:{
							print.setText("모드 :2번이 선택됨.");
							year_text.setEditable(false);
							year_text.setText("[ 랜덤 선택 ]");
							month_text.setEditable(false);
							month_text.setText("[ 랜덤 선택 ]");
							dayOfMonth_text.setEditable(true);
							dayOfMonth_text.setText("( 일을 입력하세요... )");
							break;
						}

						case 3:{
							print.setText("모드 :3번이 선택됨.");
							year_text.setEditable(false);
							year_text.setText("[ 랜덤 선택 ]");
							month_text.setEditable(true);
							month_text.setText("( 월을 입력하세요... )");
							dayOfMonth_text.setEditable(true);
							dayOfMonth_text.setText("( 일을 입력하세요... )");
							break;
						}
						case 4:{
							print.setText("모드 :4번이 선택됨.");
							year_text.setEditable(true);
							year_text.setText("( 연도를 입력하세요... )");
							month_text.setEditable(true);
							month_text.setText("( 월을 입력하세요... )");
							dayOfMonth_text.setEditable(true);
							dayOfMonth_text.setText("( 일을 입력하세요... )");
							break;
						}
					}
				}
			}
		}
		
		// 10. 결과확인하기 버튼 리스너
		class MyCalbtn_L implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(!login_state) {
					System.out.println("로그인 상태가 아님.");
					print.setText("로그인이 필요합니다.");
				}else {
					if(setting(year_input, month_input, day_input, mod)) {
						// 세팅에 이상이 없는 경우 -> 세팅은 if 조건문 확인과 동시에 진행됨.
						if(calendar_type == 0) {
							dayOfWeek_answer = FindDayOfWeek.findDayOfWeek(year_set, month_set, day_set);		// 양력인 경우.
						}else {				
							dayOfWeek_answer = FindDayOfWeek.findDayOfWeek_lun(year_set, month_set, day_set);	// 음력인 경우.
						}


						dayOfWeek_index = FindDayOfWeek.get_dayOfWeek_Index(dayOfWeek_input);	// index는 입력을 따라감.
						
						if(dayOfWeek_input.equals(dayOfWeek_answer)) {
							print.setText("[정답] ("+calendar_type_string[calendar_type]+") "+year_set+"-"+month_set+"-"+day_set+"은 " +dayOfWeek_answer);
							user[find_index].score[dayOfWeek_index] += 3;
							user[find_index].success_count++;
						}else {
							print.setText("[오답] ("+calendar_type_string[calendar_type]+") "+year_set+"-"+month_set+"-"+day_set+"은 " +dayOfWeek_answer);
							user[find_index].score[dayOfWeek_index] -= 1; 
							user[find_index].fail_count++;		
						}
						
						score_text.setText(user[find_index].getTotal()+"점");
						winrate_text.setText(user[find_index].calWinRate()+"%");
						rank_text.setText(user[find_index].calRank(user)+"위");
						
					}else {
						print.setText("입력값을 다시 확인해주세요.");
					}
				}
			}
		}

		//===============================================================
		//메소드
		// 1. 모드에 따른 입력값 세팅 
		public boolean setting(int year, int month, int day, int mod) {
			try {
				System.out.println("=====================================================");
				//[연도] 세팅
				this.year_set = (mod!=4) ? (int) (Math.random() * 151 + 1900) : year;
				if (this.year_set < 1900 || this.year_set > 2050) {
					System.out.print("연도는 1900~2050년 사이로 지정해주세요.");
					throw new Exception(); // 올바르지 않는 입력일 경우 예외 발생.
				}
				System.out.println("년 :"+year_set+" 세팅 완료");
				
				
				//[월] 세팅
				this.month_set = (mod==1 || mod==2) ?  (int) (Math.random() * 12 + 1) : month;
				if (this.month_set < 1 || this.month_set > 12) {
					System.out.print("월은 1~12월 사이로 지정해주세요.");
					throw new Exception(); // 올바르지 않는 입력일 경우 예외 발생
				}
				System.out.println("월 :"+month_set+" 세팅 완료");
				
				// maxDay 계산을 위하여 중간 set
				cal.set(Calendar.YEAR, this.year_set);
				cal.set(Calendar.MONTH, this.month_set-1);
				this.maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				
				// [일] 세팅
				this.day_set = (mod == 1) ? (int) (Math.random() * maxDay + 1)	: day;
				if (this.day_set < 1 || this.day_set > maxDay) {
					System.out.print("잘못된 날짜 입력입니다. ");
					throw new Exception(); // 올바르지 않는 입력일 경우 예외 발생
				}
				System.out.println("일 :"+day_set+" 세팅 완료");
				
				System.out.println("=====================================================");
				
		
			}catch (Exception e) {
				System.out.println("세팅에 실패하였습니다.");
				return false;
				// 세팅 과정 중 문제가 생기면 false로 실패했음을 알림.
			}
		
			return true;		
			
			
		}
		//===============================================================
		public static void main(String[] args) {

			new FindDayofWeekGame_GUI();

		}

	}

	
				



			


import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {
	int year_in, month_in, dayOfMonth_in, maxDay;
	String dayOfWeek_in;
	
	public void printPlayList() {
		// 플레이 할 게임 리스트 출력 메소드
		System.out.println("============================");
		System.out.println("[1] 년, 월, 일 모두 랜덤");
		System.out.println("[2] 년, 월 랜덤 (일 선택)");
		System.out.println("[3] 년 랜덤 (월, 일 선택)");
		System.out.println("[4] 모두 선택");
		System.out.println("게임중단 - '그만'");
		System.out.println("============================");
	}

	public boolean set(String line, int mod) {
		// 종류에 따른 년/월/일/요일 세팅 메소드	(정상입력 : T, 예외발생 : F 반환)
		Calendar cal = Calendar.getInstance();
		StringTokenizer st = new StringTokenizer(line, " ");
		
		try {
			// [년] mod = 1~3: 랜덤세팅, 4: 사용자 값 지정
			this.year_in = (mod <= 3 && mod >= 1) ? (int) (Math.random() * 26 + 2000)	: Integer.parseInt(st.nextToken().trim());
			if (this.year_in < 2000 || this.year_in > 2025) {
				System.out.print("연도는 2000~2025년 사이로 지정해주세요.");
				throw new Exception(); // 올바르지 않는 입력일 경우 예외 발생
			}
			
			// [월] mod = 1~2: 랜덤세팅, 3~4: 사용자 값 지정
			this.month_in = (mod <= 2 && mod >= 1) ? (int) (Math.random() * 12 + 1)	: Integer.parseInt(st.nextToken().trim());
			if (this.month_in < 1 || this.month_in > 12) {
				System.out.print("월은 1~12월 사이로 지정해주세요.");
				throw new Exception(); // 올바르지 않는 입력일 경우 예외 발생
			}
			
			// maxDay 계산을 위하여 중간 set
				cal.set(Calendar.YEAR, this.year_in);
				cal.set(Calendar.MONTH, this.month_in - 1);

			// Calendar 클래스를 통한 maxDay 계산.
			this.maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

			// [일] mod = 1: 랜덤세팅, 2~4: 사용자 값 지정
			// - 랜덤 세팅일 시 위에서 구한 maxDay를 통해 범위 조절
			this.dayOfMonth_in = (mod == 1) ? (int) (Math.random() * maxDay + 1)	: Integer.parseInt(st.nextToken().trim());
			if (this.dayOfMonth_in < 1 || this.dayOfMonth_in > maxDay) {
				System.out.print("잘못된 날짜 입력입니다. ");
				throw new Exception(); // 올바르지 않는 입력일 경우 예외 발생
			}
			
			//	[요일]
			this.dayOfWeek_in = st.nextToken().trim(); 
			if (!FindDayOfWeek.check_dayOfWeek(this.dayOfWeek_in)) {
				System.out.print("잘못된 요일 입력입니다. ");
				throw new Exception(); // 올바르지 않는 입력일 경우 예외 발생
			}
			return true;
		} catch (Exception e) {
			System.out.println("다시 입력하세요.");
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game game = new Game();
		User[] user = new User[5];
		
		int mod;				// 플레이 게임 종류 저장. -> 점수 = (정답) +mod, (오답) -mod
		boolean find;		// 기존 계정 비교 (기본 F / 찾으면 T)
		int find_index = 0;	// 계정을 찾으면 해당 인덱스를 저장 -> 이후 점수 카운트에 이용
		int dayOfWeek_index; // 입력한 요일 별 점수화 하기 위한 요일 인덱스 변수(월:0,화:1 ...)

		while (true) {
			find = false;	// 반복시마다 변수 초기화 과정.
			
			//===================================[계정 체크]=======================================//
			System.out.println("플레이 할 계정을 선택해주세요. (신규 생성 > '생성', 종료 > '그만')");
			String username = sc.nextLine();
			if (username.equals("그만"))	break;
			if (username.equals("생성")) {
				if (User.count >= 5) {	// user 최대 인덱스 초과 여부 체크 조건문
					System.out.println("계정 생성 한도.");
					continue;
				} else {
					System.out.printf("생성할 계정이름을 입력하세요. >>");
					try {
						String name = sc.nextLine();
						user[User.count] = new User(name.trim());
						User.count++;
						continue;
					} catch (Exception e) {
						System.out.println("잘못된 계정이름 입니다.");
					}
				}
			} 
			
			for (int i = 0; i < User.count; i++) {
				if (user[i].getID().equals(username.trim())) {
					find = true; // 계정을 찾음.
					find_index = i;
					break;
				}
			}
			if (find == false) {	// 계정을 못찾음.
				System.out.println("등록되지 않는 계정입니다. 신규생성이 필요합니다.");
				continue;
			}
			
			//===================================[게임 실행]=======================================//
			while (true) {
				System.out.println("플레이 할 게임을 선택해주세요.");
				game.printPlayList();	// 게임리스트 출력 메소드

				String line = sc.nextLine();
				if (line.equals("그만"))
					break; // 반복문 종료
				try {
					mod = Integer.parseInt(line); // 게임 종류 선택
					if (mod < 1 || mod > 4)
						throw new Exception(); 	 // 잘못된 입력 검증

					switch (mod) { // 게임 종류에 따른 다른 안내문 출력
					case 1:
						System.out.println("요일을 입력하세요.");
						break;
					case 2:
						System.out.println("일과 요일을 입력하세요.");
						break;
					case 3:
						System.out.println("월, 일, 요일을 입력하세요.");
						break;
					case 4:
						System.out.println("년, 월, 일, 요일을 입력하세요.");
						break;
					}

				} catch (Exception e) { // 잘못된 입력 시 반복문 재실행
					System.out.println("잘못된 입력입니다. 다시 입력하세요.\n");
					continue;
				}

				String setline = sc.nextLine(); 
				
				// 입력에 따른 세팅 (입력 검증은 메소드 안에서 이루어짐. T:정상, F : 예외발생)
				if(!game.set(setline, mod)) continue;	
				

				// 해당 날짜에 맞는 요일을 리턴
				String dayOfWeek = FindDayOfWeek.findDayOfWeek(game.year_in, game.month_in, game.dayOfMonth_in);
				
				// 입력 날짜와 정답요일 출력
				System.out.println("\n" +game.year_in + "년 " + game.month_in + "월 " + game.dayOfMonth_in + "일은 <" + dayOfWeek + ">입니다.");
				
				// 입력한 요일을 int로 변환 (월:0,화:1...)
				dayOfWeek_index = FindDayOfWeek.get_dayOfWeek_Index(game.dayOfWeek_in); 

				if (dayOfWeek.equals(game.dayOfWeek_in)) { // 입력한 요일과 정답이 일치하는지 체크
					System.out.println("<<정답>>\n");
					if(mod != 4) {
						user[find_index].score[dayOfWeek_index] += 3; // 모두 선택하는 mod=4가 아니라면 3점 증가
						user[find_index].success_count++;			 // 성공 횟수 기록
					}
				} else {
					System.out.println("<<오답>>\n");
					if(mod != 4) {
						user[find_index].score[dayOfWeek_index] -= 1; // 모두 선택하는 mod=4가 아니라면 1점 감소
						user[find_index].fail_count++;				 // 실패 횟수 기록
					}
				}
				user[find_index].printScore(user);
				
			}
		}
	}
}

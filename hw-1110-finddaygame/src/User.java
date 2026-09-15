
public class User {
	public static int count = 0; // 계정 개수 기록을 위한 전역변수 용도의 정수형 변수
	private String ID;
	int success_count;
	int fail_count;
	public int[] score = new int[7]; 
	
	//User 클래스의 생성자. 매개변수 ID를 입력받아 객체 생성 + 점수 초기화.
	User(String ID) {		
		this.ID = ID;
		for(int i =0; i<7;i++) {
			this.score[i]=0;
		}
		this.success_count=0;
		this.fail_count=0;
	}
	// ID 반환 메소드
	public String getID() {
		return this.ID;
	}
	
	// 점수 합계 반환 메소드
	public int getTotal() {
		int sum =0;
		for(int n : this.score) {
			sum +=n;
		}
		return sum;
	}
	
	// 점수 출력 메소드
	public void printScore(User[] user) {
		System.out.print("=================================================================\n");
		System.out.print(this.ID + "\t: 월\t화\t수\t목\t금\t토\t일\n");
		System.out.print("점수 \t: ");
		for(int n : this.score) {
			System.out.print(n +"\t");
		}
		System.out.print("\n");
		System.out.print("승률 \t: "+ calWinRate()+"\n");
		System.out.print("순위 \t: "+ calRank(user) +"위 (전체: "+count+"명)\n");
		System.out.print("=================================================================\n\n");
	}
	
	// 승률 계산 메소드
	public double calWinRate() {
		if(success_count+fail_count==0) return 0;
		else return (double)success_count/(success_count+fail_count);
	}
	
	// 순위 계산 메소드 (해당 객체를 전달 받아야 다른 계정에 접근 가능 -> 매개변수)
	public int calRank(User[] user) {
		int rank=1;
		int[] totalScore = new int[count];
		for(int i = 0; i<count; i++) {
			totalScore[i]=user[i].getTotal();
		}
		for(int n : totalScore) {
			if(this.getTotal()<n) {
				rank++;
			}
		}
		return rank;
	}
}

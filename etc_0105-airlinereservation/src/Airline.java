
public class Airline {
	// 01. 변수선언
	final int max_row = 4;
	final int max_column = 10;
	int point[][] = new int[max_row][max_column];


	
	
	// 02. 메소드
	// 2.1. 현황 출력
	public void displaySeats() {
		System.out.println("+-----------------------------------------------------------+");
		System.out.println("AAA 항공사 예약 현황");
		System.out.println("+-----------------------------------------------------------+");
		
		for(char i ='D'; i>='A'; i--) {
			for(int j=1;j<=max_column; j++) {
				System.out.print("| "+j+i +" ");
			}
			System.out.println("|");
			System.out.println("+-----------------------------------------------------------+");
			
			for(int k=1;k<=max_column; k++) {
				if(point['D'-i][k-1]==1) {
					System.out.print("|  O ");
				}else {
					System.out.print("|  X ");
				}
			}
			System.out.println("|");
			System.out.println("+-----------------------------------------------------------+");
		}
	}
	
	// 2.2. 유효성 검사
	public boolean checkData(String s) {
		int c = 0;
		char r = 'A';
		
		try{
			if(s.length()==2) {
				c = Integer.valueOf(s.substring(0,1));
				r = s.substring(1,2).charAt(0);
				
			}else if(s.length()==3){
				c = Integer.valueOf(s.substring(0,2));
				r = s.substring(2,3).charAt(0);
			}else {
				System.out.println("Wrong seat name. Type again");
			}
			
			
			if(c>=1 && c <=max_column) {
				if(r>='A' && r<= (char)('A'+max_row)) {
					return true;
				}else {
					System.out.println("Invalid row index");
				}
			}else {
				System.out.println("Invalid column index");
			}
		}catch(Exception e) {
			System.out.println("그냥 이건 걍 오류 ㅇㅇ");
		}
	
		return false;
	}
	
	
	// 2.3. point index 계산
	public int calRowIndex(String s){
		char row = 0;
	
		if(s.length()==2) {
			row = s.substring(1,2).charAt(0);
			
		}else if(s.length()==3){
			row = s.substring(2,3).charAt(0);
		}
		
		return (int)('D'-row);
		
	}
	
	public int calColIndex(String s){
		int col = 0;
		
		if(s.length()==2) {
			col = Integer.valueOf(s.substring(0,1));
			
		}else if(s.length()==3){
			col = Integer.valueOf(s.substring(0,2));
		}
		
		return col - 1;
	}
	
	
	// 2.4. 세팅
	public void setPoint(String s) {
		if(this.checkData(s)) {
			System.out.println("rowChar: "+ (char)('D'-calRowIndex(s))+", colString: "+ (int)(1+calColIndex(s)));
			
			if(this.point[calRowIndex(s)][calColIndex(s)] == 0) {
				this.point[calRowIndex(s)][calColIndex(s)] = 1;	
				System.out.print("["+calRowIndex(s)+"]["+calColIndex(s)+"] -> ");
				System.out.println("Reservation success");
			}else {
				System.out.print("["+calRowIndex(s)+"]["+calColIndex(s)+"] -> ");
				System.out.println("Reservation Fail(Reserved Seat)");
			}
			
			
		}
		
	}


	
}

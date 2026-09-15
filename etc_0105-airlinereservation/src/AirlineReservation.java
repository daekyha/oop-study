import java.util.Scanner;

public class AirlineReservation {
	
	
	
	public static void main(String[] args) {
		Airline airline = new Airline();
		
		
		while(true) {
			airline.displaySeats();
			Scanner sc = new Scanner(System.in);
			
			System.out.print("좌석이름을 입력하세요: ");
			String txt = sc.nextLine().trim();
			
			if(txt.equals("quit")) {
				break;
			}
			
			airline.setPoint(txt);
			
		
		}
		System.out.println("프로그램 종료");
	}
}

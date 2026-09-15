import java.util.Scanner;

public class Main_0 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);		
		Boolean a=true;
		int mod =0;
		
		while (a) {
			System.out.print("실행할 코드 >> ");
			try{
				mod=scanner.nextInt();				
			}catch (Exception e) {
				System.out.println("잘못된 입력");
				continue;
			}
			
			switch (mod) {
			case 0:
				a=false;
				break;
			// ==============================================================//
			case 1:
				System.out.println("["+mod+"번 코드 실행"+"]");
				Point p = new Point();
				p.set(1, 2);
				p.showPoint();

				ColorPoint cp = new ColorPoint();
				cp.set(2, 4);
				cp.setColor("red");
				cp.showColorPrint();
				break;
			// ==============================================================//
			case 2:
				System.out.println("["+mod+"번 코드 실행"+"]");
				Student s = new Student();
				s.set();
				break;
			// ==============================================================//
			default: 
				a=false;
			}
		}
	}
}

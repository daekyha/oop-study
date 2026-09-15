import java.util.*;

public class Ex_03 {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		
		Scanner sc= new Scanner(System.in);
		
		for(int i =0; i<4;i++) {
			System.out.print("문자를 입력하세요 >>");
			String  s = sc.nextLine();
			a.add(s);
		}
		
		for(int i = 0 ; i<a.size();i++) {
			System.out.print(a.get(i)+" ");
		}
		
		int longindex =0;
		for(int i=1;i<a.size();i++) {
			if(a.get(longindex).length()<a.get(i).length()) {
				longindex =i;
			}
		}
		
		System.out.println("\n가장 긴 이름은 "+a.get(longindex));
		
		
	}
}

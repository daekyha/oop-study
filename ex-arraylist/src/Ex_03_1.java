import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex_03_1 {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		Scanner sc= new Scanner(System.in);
		
		for(int i =0; i<4;i++) {
			System.out.print("숫자를 입력하세요 >>");
			try {				
				int num = Integer.parseInt(sc.nextLine()); 
				a.add(num);
			}catch(Exception e){
				System.out.println("잘못된 입력. 다시 입력하세요.");
				continue;
			}
		}
		
		System.out.println("==============================");
		System.out.print("입력 된 숫자 : ");
		for(int i = 0 ; i<a.size();i++) {
			System.out.print(a.get(i)+" ");
		}
		
		int longindex =0;
		for(int i=1;i<a.size();i++) {
			if(a.get(longindex)<a.get(i)) {
				longindex =i;
			}
		}
	
		System.out.println("\n가장 큰 숫자 : "+a.get(longindex));
		System.out.println("==============================");
//		
//		for(int i=0; i<4;i++){
//			int index =0;
//			
//			for(int j = 1;j<a.size();j++) {
//				if(a.get(index)<a.get(j)) {
//					index =j;
//				}
//			}
//			System.out.print(a.get(index)+"-");
//			a.remove(index);
//		}
//		
//		System.out.println("\n==============================");
		System.out.println("[Iterator]");
		Iterator<Integer> it = a.iterator();
		
		while (it.hasNext()) {
			int n = it.next();
			System.out.print(n + " ");
		}
		
		System.out.println("==============================");
		System.out.println("[Iterator]");
		it =a.iterator();
		int sum=0;
		while (it.hasNext()) {
			sum+=it.next();
		}
		System.out.println("총 합" + sum);
		sc.close();
//		
//		System.out.println("==============================");
//		System.out.println("[Iterator]");
//		
//			
//		int max=0;
//		while (it.hasNext()) {
//			int m = it.next();
//			max = (m>max) ? m : max;
//		}
//		System.out.println(max +" ");
//		a.remove(max);
//		it =a.iterator();
		
		
		
		
	}
}

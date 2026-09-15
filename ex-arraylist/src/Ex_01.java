import java.util.Vector;

public class Ex_01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2, 100);
		
		System.out.println("저장 객체 수 : "+v.size());
		System.out.println("현재 용량 : " + v.capacity());
		
		System.out.println("=====================================");
		for(int n : v) {
			System.out.println(n);
		}
		System.out.println("=====================================");
		for(int i =0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		System.out.println("=====================================");
		int sum =0;
		for(int m : v) {
			sum+=m;
		}
		System.out.println("총 합 :" +sum);
		
		System.out.println("=====================================");
		sum =0;
		for(int i =0;i<v.size();i++) {
			sum += v.elementAt(i);
		}
		System.out.println("총 합 :" +sum);
		
	}
}

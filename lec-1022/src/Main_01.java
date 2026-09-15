
public class Main_01 {
	public static void main(String[] args) {
		C c1 = new C(1);
		System.out.println("====================================");
		C c2 = new C(1,2,3);
		System.out.println("====================================");
		B b1 = new B();
		System.out.println("====================================");
		D d1 = new D();
		System.out.println("====================================");	
	}

}

class A{
	int x;
	int y;
	
	A(int x){
		System.out.println("A-1번 생성자 실행");
		this.x=x;
	}
	
	A(int x,int y){
		System.out.println("A-2번 생성자 실행");
		this.x=x;
		this.y=y;
	}
}

class B extends A{
	int z;
	B(int x){
		super(x);
		System.out.println("B-1번 생성자 실행");
	}
	
	B(){
		super(2);
		System.out.println("B-2번 생성자 실행");
	}
	
	B(int x, int y, int c){
		super(2,3);
		int z=x;
		System.out.println("B-3번 생성자 실행");
	}
	
	
	
}

class C extends B{
	C(int x){
		super(x);
		System.out.println("C-1번 생성자 실행");
	}
	
	C(){
		super(2);
		System.out.println("C-2번 생성자 실행");
	}
	
	C(int x, int y, int c){
		super(2,3,c);
		int z=x;
		System.out.println("C-3번 생성자 실행");
	}
	
}

class D extends C{
	D(){
		System.out.println("D-1번 생성자 실행");
	}
	D(int x){
		System.out.println("D-2번 생성자 실행");
	}
}
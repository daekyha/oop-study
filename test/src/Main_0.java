
public class Main_0 {
	public static void main(String[] args) {
		System.out.println("test");
		new B().aa();
	}
}


class A{
	public void aa() {
		aa();
		System.out.println(11);
	}
}

class B extends A{
	public void aa() {
		super.aa();
		System.out.println(11);
	}
}
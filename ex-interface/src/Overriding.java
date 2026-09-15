
public class Overriding {
	public static void main(String[] args) {
		Weapon weapon;
		weapon = new Weapon();
		System.out.println(new Weapon().fire());
		
		System.out.println(new Canon().fire());
		
		//System.out.println(new Weapon().aa());
		//System.out.println(new Canon().aa());
	}
}

class Weapon {
	protected int fire() {
		return 1;
	}
	private int aa() {
		return 0;
	}
}

class Canon extends Weapon {
	protected int fire() {
		return 1213;
	}
//	@Override
//	//int aa() {
//		return 2;
//	}
}
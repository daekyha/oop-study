class Rect {
	private int w;
	private int h;

	Rect(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public boolean equals(Object obj) {
		Rect p = (Rect) obj;
		return (w * h == p.w * p.h) ? true : false;
	}
}

public class Ex_04 {
	public static void main(String[] args) {
		Rect a = new Rect(2, 3);
		Rect b = new Rect(3, 2);
		Rect c = new Rect(3, 4);
		if(a.equals(b)) System.out.println("a.equals(b)");
		if(a.equals(c)) System.out.println("a.equals(c)");
		if(a.equals(c)) System.out.println("b.equals(c)");
	}
}

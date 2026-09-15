class Point2 extends Point{
	public Point2(int x, int y) {
		super(x, y);
	}
	
	@Override
	public String toString() {
		return "Point ("+ getX() +"," + getY() +")" ;
	}
	
}
public class Ex_02 {
	public static void main(String[] args) {
		Point2 p = new Point2(2, 3);
		System.out.println(p.toString());
		System.out.println(p);
		System.out.println(p+"입니다.");
	}
}

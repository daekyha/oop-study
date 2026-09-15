class Point3 extends Point {
	public Point3(int x, int y) {
		super(x, y);
	}
	
	@Override
	public boolean equals(Object obj) {
		Point3 p= (Point3)obj;
		return (getX()==p.getX()&&getY()==p.getY()) ?  true : false;
	}
	
}
public class Ex_03 {
	public static void main(String[] args) {
		Point3 a = new Point3(2, 3);
		Point3 b = new Point3(2, 3);
		Point3 c = new Point3(3, 4);
		if(a==b) System.out.println("a==b");
		if(a.equals(b)) System.out.println("a.equals(b)");
		if(a.equals(c)) System.out.println("a.equals()");
	}
}

class Point{
	// 문제에서 주어진 Point 클래스 및 메소드들.
	private int x, y;
	public Point(int x, int y) {this.x=x; this.y=y;}
	
	public int getX() {
		return this.x;
	}	
	public int getY() {
		return this.y;
	}	
	protected void move(int x, int y) {
		this.x=x; this.y=y;
	}
	
}


class ColorPoint2 extends Point {
	// Point 클래스를 상속 받은 뒤 string 변수를 생성.
	String color;
	
	//============================[생성자]============================//
	//[1] - 인자가 없는 경우 => 기본 값 (0,0), White로 초기화.
	public ColorPoint2() {
		super(0, 0);
		this.color="WHITE";
	}
	
	//[2] - 좌표만 인자로 넘겨진 경우 => 주어진 좌표를 저장. 색상은 Black.
	public ColorPoint2(int x, int y) {
		super(x, y);
		this.color="BLACK";
	}
	
	//[3] - 좌표 + 색상 모두 넘겨진 경우 => 주어진 정보를 모두 저장.
	public ColorPoint2(int x, int y, String color) {
		super(x, y);
		this.color=color;
	}
	
	
	//============================[메소드]============================//
	// 1. 변수 변경 메소드
	
	/*
	 * => Point 클래스에서 변수가 private으로 지정되었으므로 직접 접근 X.
	 * => 별도의 메소드를 만들어 접근하기 위함.
	 */

	// 1.1. 색상 변경.
	void set(String color) {
		this.color=color;
	}
	// 1.1. 좌표 변경.
	void set(int x, int y) {
		this.move(x,y); 
	}
	
	// 2. 객체 내 정보 출력 메소드
	public String toString() {
	    return this.color + "색의 (" + this.getX() + "," + this.getY() + ")의 점";
	}

	// 3. ColorPoint2 객체를 인자로 받아 해당 객체에 저장되어 있는 위치의 거리를 계산 후 반환 
	double getDistance(ColorPoint2 point) {
		int distance_x=this.getX()-point.getX();
		int distance_y=this.getY()-point.getY();
		
		return Math.sqrt(Math.pow(distance_x,2) +Math.pow(distance_y,2));
	}
}

public class PrintColorPoint {
	public static void main(String[] args) {
		// 객체 1 생성.
		ColorPoint2 zeroPoint = new ColorPoint2();
		System.out.println(zeroPoint.toString()+"입니다.");
		
		// 객체 2 생성.
		ColorPoint2 cp = new ColorPoint2(10,10,"red");
		cp.set("BLUE");
		cp.set(10,20);
		System.out.println(cp.toString()+"입니다.");
		
		// 객체 3 생성.
		ColorPoint2 thresholdPoint = new ColorPoint2(100,100);
		System.out.println("cp에서 임계점까지의 거리는 "+cp.getDistance(thresholdPoint)); 
		// 객체 3과 2의 거리 계산 메소드 호출
		
	}
}

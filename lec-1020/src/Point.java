
public class Point {
	private int x, y;

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void showPoint() {
		System.out.println("(x: " + this.x + ", y: " + this.y + ")");
	}
}

class ColorPoint extends Point {
	private String color;

	public void setColor(String color) {
		this.color = color;
	}

	public void showColorPrint() {
		System.out.println("저장된 색상은"+color);
		showPoint();
	}
}


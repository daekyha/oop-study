import java.util.Vector;

class Shape{
	int r;
	String name;
	
	public void draw() {
		System.out.println("00");
	};
	public void print() {
		System.out.println("반지름 : "+this.r + ", 이름 : "+this.name);
	};
}

class Circle extends Shape{

	public Circle(){}
	public Circle(int r, String name){
		this.name = name;
		this.r=r;
	}
}

public class Circle_vector {
	public static void main(String[] args) {
		Vector<Circle> v = new Vector<Circle>();		
		v.add(new Circle(3,"자바 피자"));
		v.add(new Circle(7,"자바 도넛"));
		v.add(new Circle(4,"자바 축구공"));
		
		v.remove(2);
		
		for(int i =0; i<v.size();i++) {
			Circle c = v.get(i);
			c.print();
		}
		
		
	}
	
	
}

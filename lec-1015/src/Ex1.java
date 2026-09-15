
public class Ex1 {
	public static void main(String[] args) {
		TV tv = new TV("samsung",50,300);
		tv.show();
	}
}

class TV{
	String name;
	int size;
	int price;
	
	TV(String name,int size, int price){
		this.name = name;
		this.size=size;
		this.price=price;
	}
	
	void show(){
		System.out.println(this.name+"에서 만든 "+this.price+"만원짜리의 "+this.size+"인치 TV");
	}
}
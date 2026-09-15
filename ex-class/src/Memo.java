
public class Memo {
	String name, time, content;
	int lenth;

	boolean isSameName(Memo memo) {
		return (this.name.equals(memo.name));
	}

	String getName() {
		return this.name;
	}

	void show() {
		System.out.println(this.name + ", " + this.time + " " + this.content);
	}

	
	Memo(String name, String time, String content){
		this.name=name;
		this.time=time;
		this.content=content;
		this.lenth=this.content.length();
	}

	public static void main(String[] args) {
		Memo a=new Memo("유송연","10:10","자바 과제");
		Memo b=new Memo("유송연1","10:10","자바 과제");
		Memo c=new Memo("유송연2","10:10","자바 과제");
		
		a.show();
		if(a.isSameName(b)) {
			System.out.println("동일한 사람");
		}else {
			System.out.println("다른 사람");
		}
		System.out.println(c.getName()+"가 작성한메모의 길이는 "+c.lenth);
	}
}

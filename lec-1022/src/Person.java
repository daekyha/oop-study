
public class Person {
	String id;
	String name;
	//public Person() {}
	public Person(String name) {
		this.name= name;
	}
	
}

class Student extends Person {
	String grade;
	String department;
	
	public Student(String name) {
		super(name);
	}
}


//class Student1 extends Person {
//	String aa;
//	String bb;
//	
//	public Student1() {
//		System.out.println("1번");
//	}
//}


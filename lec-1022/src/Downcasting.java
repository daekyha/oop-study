
public class Downcasting {
	public static void main(String[] args) {
		Person p = new Student("이재문");
		Student s;
		s = (Student)p;
		
		
		System.out.println(s.name);
		
	}
}

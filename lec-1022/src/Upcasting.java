
public class Upcasting {
	public static void main(String[] args) {
		Person p;
		Student s = new Student("이재문");
		p = s;
		
		System.out.println(p.name);
		
		//System.out.println(p.grade);
		//System.out.println(p.department);
		//불가능.
		
	}
}

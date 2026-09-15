interface ZZ{
	public void a();
}	
class AA implements ZZ{
	public void a() {};
}	
class BB implements ZZ{
	public void a() {};
}	
class CC implements ZZ{
	public void a() {};
}
public class Test {
	public static void main(String[] args) {
		ZZ z = new CC();
		AA a = new AA();
		BB b = new BB();
		
		z=a;
		
	}
}

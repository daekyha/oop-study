
public class Average {
	int intArray [] = new int [10];
	int index;
	public Average() {
		this.index = 0;
	}
	
	void put(int num) {
		this.intArray[index]=num;
		index++;
	}
	
	void showAll() {
		for(int i=0;i<index;i++) {
			System.out.print(intArray[i] + "\t");
		}
		System.out.println("");
	}
	
	double getAvg() {
		double sum = 0.0;
		for(int i=0;i<index;i++) {
			sum+=intArray[i];
		}
		return sum/index;
	}

	
	public static void main(String[] args) {
		Average avg = new Average();
		avg.put(10);
		avg.put(15);
		avg.put(100);
		avg.showAll();
		
		System.out.println("평균은 "+ avg.getAvg());
		
	}
}

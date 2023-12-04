package n1ex01;

public class Main {

	public static void main(String[] args) {
		
		// Demonstrate @Override annotation
		
		Worker worker1 = new Worker("Pep", "Lopez", 7.75f);
		OnlineWorker onWorker1 = new OnlineWorker("Maria", "Pau", 9.5f);
		OfficeWorker ofWorker1 = new OfficeWorker("Pau","Roca", 25.0f);
		
		System.out.println(worker1.toString());
		System.out.println(onWorker1.toString());
		System.out.println(ofWorker1.toString());
		
		System.out.println("\n-Demonstrate @Override annotation");
		worker1.calcSalary(50);
		onWorker1.calcSalary(100);
		ofWorker1.calcSalary(160);
		
		

	}

}

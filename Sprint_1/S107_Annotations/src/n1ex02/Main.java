package n1ex02;


public class Main {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
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
		
		// Calling deprecated methods, suppressing warnings
		System.out.println("\n-Using deprecated methods");
		onWorker1.addHomeEnergyPlus(1800.0f);
		ofWorker1.addlunchPlus(2000.0f);
	}
}

package n1ex02;

public class Cotxe {
	
	//attrib
		//static final(const. de classe): no pot inicialitzar en el constr.,no modif., mateix valor x tots obj.
	private static final String MARCA = "Honda"; 
		//static: pot inicialitzar en el constr., si modif. modif tots obj., mateix valor x tots obj. 
	private static String model;	
		//final(constant): pot inicialitzar en el constr., no modif.
	private final int POTENCIA;					 
	
	//constr
	public Cotxe() {
		Cotxe.model = "Jazz";
		this.POTENCIA = 1600;
	}
	
	//getters
	public static String getMARCA() {
		return MARCA;
	}
	public static String getModel() {
		return model;
	}
	public int getPOTENCIA() {
		return this.POTENCIA;
	}
	
	//setters
	public static void setModel(String model) {
		Cotxe.model = model;
	}
	
	
	//methods
	public static void frenar() {
		System.out.println("El vehicle està frenant");
	}
	
	public void accelerar() {
		System.out.println("El vehicle està accelerant");
	}
	
	//own methods
	@Override
	public String toString() {
		return "Cotxe-> marca: " + Cotxe.MARCA + ", model: " + Cotxe.model + ", potencia: " + this.POTENCIA;
	}
}

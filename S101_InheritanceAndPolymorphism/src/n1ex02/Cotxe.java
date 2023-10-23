package n1ex02;

public class Cotxe {
	
	//attrib
	private static final String marca = "Honda";
	private static String model;
	private final int POTENCIA = 1600;
	
	//constr
	public Cotxe(String model) {
		Cotxe.model = model;
	}
	
	//getters
	public static String getMarca() {
		return marca;
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
}

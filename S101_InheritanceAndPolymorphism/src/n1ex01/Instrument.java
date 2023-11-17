package n1ex01;

public abstract class Instrument {

	private String nom;
	private int preu;
	
	public Instrument(String nom, int preu) {
		this.nom = nom;
		this.preu = preu;
	}
	
	public String getNom() {
		return this.nom;
	}
	public int getPreu() {
		return this.preu;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPreu(int preu) {
		this.preu = preu;
	}
	
	// Bloc inicialització, el crida a cada cop que usem constructor
	{
		System.out.println("Bloc inicialització (classe Instr.): Instrument creat");
	}
	// Bloc static, el crida el primer cop (abans que el bloc d'inicialització)
	static {
		System.out.println("Inicialització bloc static a la classe Instrument");
	}
	
	public static void metodeStatic(){
		System.out.println("Mètode static a la classe Instrument");
	}
	public abstract String tocar();
}

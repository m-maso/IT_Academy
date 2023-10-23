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
	
	
	public abstract String tocar();
}

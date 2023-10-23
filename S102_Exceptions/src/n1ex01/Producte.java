package n1ex01;

public class Producte {
	
	// Attrib
	private String nom;
	private float preu;
	
	// Constr
	public Producte(String nom, float preu) {
		this.nom = nom;
		this.preu = preu;
	}
	
	// Getters
	public String getNom() {
		return this.nom;
	}
	public float getPreu() {
		return this.preu;
	}
	
	// Setters
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPreu(float preu) {
		this.preu = preu;
	}
	
	// Methods
	@Override
	public String toString() {
		return "Producte: " + this.nom + "\nPreu: " + this.preu;
	}
}

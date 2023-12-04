package n3ex01;

public abstract class Noticia {
	
	// Attrib
	private String titular;
	protected String text; 
	protected int puntuacio;
	protected int preu;
	
	// Constr
	public Noticia(String titular) {
		this.titular = titular;
		this.text = " ";
		this.puntuacio = 0;
		this.preu = 0;
	}
	
	// Getters
	public String getTitular() {
		return this.titular;
	}
	public String getText() {
		return this.text;
	}
	public int getPuntuacio() {
		return this.puntuacio;
	}
	public int getPreu() {
		return this.preu;
	}
	
	
	// Setters
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}
	public void setPreu(int preu) {
		this.preu = preu;
	}
	
	
	
	// Grl methods
	public abstract int calcularPreuNoticia();
	public abstract int calcularPuntuacioNoticia();
	
}

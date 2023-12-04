package n3ex01;

public class NotTenis extends Noticia {
	
	// Attrib
	private String competicio;
	private String tenista;
	
	// Constr
	public NotTenis(String titular, String competicio, String tenista) {
		super(titular);
		this.text = "";
		this.preu = 150;
		this.puntuacio = 4;
		this.competicio = competicio;
		this.tenista = tenista;
	}
	
	// Getters
	public String getCompeticio() {
		return this.competicio;
	}
	public String getTenista() {
		return this.tenista;
	}
	
	// Setters
	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}
	public void setTenista(String tenista) {
		this.tenista = tenista;
	}
	
	
	// Grl Methods
	@Override
	public int calcularPreuNoticia() {
		int preuN = this.preu;

        if(this.tenista.equalsIgnoreCase("Federer") || this.tenista.equalsIgnoreCase("Nadal") || this.tenista.equalsIgnoreCase("Djokovic")) {
            preuN += 100;
        }
        return preuN;
	}
	
	@Override
	public int calcularPuntuacioNoticia() {
		int puntN = this.puntuacio;

        if(this.tenista.equalsIgnoreCase("Federer") || this.tenista.equalsIgnoreCase("Nadal") || this.tenista.equalsIgnoreCase("Djokovic")) {
            puntN += 3;
        }
        return puntN;
	}
	
	// Own Methods
	@Override
	 public String toString() {
		return "Noticia Tenis -> Titular: " + this.getTitular() + "\nCompetició: " + this.getCompeticio() 
        + "\nTenista: " + this.getTenista() + "\n";
    }
}

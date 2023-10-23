package n3ex01;

public class NotF1 extends Noticia {
	
	// Attrib
	private String escuderia;
	
	// Constr
	public NotF1(String titular, String escuderia) {
		super(titular);
		this.text = "";
		this.preu = 100;
		this.puntuacio = 4;
		this.tipusNot = "F1";
		this.escuderia = escuderia;
	}
	
	// Getter
	public String getEscuderia() {
		return this.escuderia;
	}
	// Setter
	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}
	
	
	// Grl Methods
	@Override
	public int calcularPreuNoticia() {
		int preuN = this.preu;

        if((this.escuderia.equalsIgnoreCase("Ferrari") || (this.escuderia.equalsIgnoreCase("Mercedes")))) {
            preuN += 50;
        }
        return preuN;
	}
	
	@Override
	public int calcularPuntuacioNoticia() {
		int puntN = this.puntuacio;

        if((this.escuderia.equalsIgnoreCase("Ferrari") || (this.escuderia.equalsIgnoreCase("Mercedes")))) {
            puntN += 2;
        }
        return puntN;
	}
	
	// Own Methods
	@Override
	 public String toString() {
		return "Noticia F1 -> Titular: " + this.getTitular() + "\nEscuderia: " + this.getEscuderia() + "\n";
    }
}

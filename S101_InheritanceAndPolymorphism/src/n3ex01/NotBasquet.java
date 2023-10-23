package n3ex01;

public class NotBasquet extends Noticia {
	
	// Attrib
	private String competicio;
	private String club;
	
	// Constr
	public NotBasquet(String titular, String competicio, String club) {
		super(titular);
		this.text = "";
		this.preu = 250;
		this.puntuacio = 4;
		this.tipusNot = "Basquet";
		this.competicio = competicio;
		this.club = club;
	}
	
	// Getters
	public String getCompeticio() {
		return this.competicio;
	}
	public String getClub() {
		return this.club;
	}
	
	// Setters
	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}
	public void setClub(String club) {
		this.club = club;
	}
	
	// Grl Methods
	@Override
	public int calcularPreuNoticia() {
		int preuN = this.preu;

        if(this.competicio.equalsIgnoreCase("Eurolliga")) {
            preuN += 75;
        }
        if((this.club.equalsIgnoreCase("Barça") || (this.club.equalsIgnoreCase("Madrid")))){
            preuN += 75;
        }
        return preuN;
	}
	
	@Override
	public int calcularPuntuacioNoticia() {
		int puntN = this.puntuacio;

        if(this.competicio.equalsIgnoreCase("Eurolliga")) { puntN += 3; }
        if(this.competicio.equalsIgnoreCase("ABC")) { puntN += 2; }
        if((this.club.equalsIgnoreCase("Barça") || (this.club.equalsIgnoreCase("Madrid")))) { puntN += 1; }
        return puntN;
	}
	
	// Own Methods
	@Override
	 public String toString() {
		return "Noticia Bàsquet -> Titular: " + this.getTitular() + "\nCompetició: " + this.getCompeticio() 
        + "\nClub: " + this.getClub() + "\n";
    }
}

package n3ex01;

public class NotFutbol extends Noticia {
	
	// Attrib
	private String competicio;
	private String club;
	private String jugador;
	
	// Constr
	public NotFutbol(String titular, String competicio, String club, String jugador) {
		super(titular);
		this.text = "";
		this.preu = 300;
		this.puntuacio = 5;
		this.tipusNot = "Futbol";
		this.competicio = competicio;
		this.club = club;
		this.jugador = jugador;
	}
	
	// Getters
	public String getCompeticio() {
		return this.competicio;
	}
	public String getClub() {
		return this.club;
	}
	public String getJugador() {
		return this.jugador;
	}
	
	// Setters
	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public void setJugador(String jugador) {
		this.jugador = jugador;
	}
	
	
	// Grl Methods
	@Override
	public int calcularPreuNoticia() {
		int preuN = this.preu;

        if(this.competicio.equalsIgnoreCase("Lliga de campions")) {
            preuN += 100;
        }
        if((this.club.equalsIgnoreCase("Barça") || (this.club.equalsIgnoreCase("Madrid")))) {
            preuN += 100;
        }
        if((this.jugador.equalsIgnoreCase("Ferran Torres") || (this.jugador.equalsIgnoreCase("Benzema")))) {
            preuN +=50;
        }
        return preuN;
	}
	
	@Override
	public int calcularPuntuacioNoticia() {
		int puntN = this.puntuacio;

        if(this.competicio.equalsIgnoreCase("Lliga de campions")) { puntN += 3; }
        if(this.competicio.equalsIgnoreCase("Lliga")) { puntN += 2; }
        if((this.club.equalsIgnoreCase("Barça") || (this.club.equalsIgnoreCase("Madrid")))) { puntN += 1; }
        if((this.jugador.equalsIgnoreCase("Ferran Torres") || (this.jugador.equalsIgnoreCase("Benzema")))){ puntN += 1; }

        return puntN;
	}
	
	// Own Methods
	@Override
    public String toString() {
        return "Noticia Futbol -> Titular: " + this.getTitular() + "\nCompetició: " + this.getCompeticio() 
        + "\nClub: " + this.getClub() + "\nJugador: " + this.getJugador() + "\n";
    }
}

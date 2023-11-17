package n3ex01;

public class NotMotoc extends Noticia {
	
	// Attrib
	private String equip;
	
	// Constr
	public NotMotoc(String titular, String equip) {
		super(titular);
		this.text = "";
		this.preu = 100;
		this.puntuacio = 3;
		this.equip = equip;
	}
	
	// Getter
	public String getEquip() {
		return this.equip;
	}
	// Setter
	public void setEquip(String equip) {
		this.equip = equip;
	}
	
	// Grl Methods
	@Override
	public int calcularPreuNoticia() {
		int preuN = this.preu;

        if(this.equip.equalsIgnoreCase("Honda") || this.equip.equalsIgnoreCase("Yamaha")) {
            preuN += 50;
        }
        return preuN;
	}
	
	@Override
	public int calcularPuntuacioNoticia() {
		int puntN = this.puntuacio;

        if(this.equip.equalsIgnoreCase("Honda") || this.equip.equalsIgnoreCase("Yamaha")) {
            puntN += 3;
        }
        return puntN;
	}
	
	// Own Methods
	@Override
	 public String toString() {
		return "Noticia Motociclisme -> Titular: " + this.getTitular() + "\nEquip: " + this.getEquip() + "\n";
    }
}

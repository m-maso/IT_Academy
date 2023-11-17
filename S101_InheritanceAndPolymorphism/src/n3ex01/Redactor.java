package n3ex01;

import java.util.ArrayList;

public class Redactor {
	
	// Attrib
	private String nom;
	private final String DNI;
	private static int sou;
	private ArrayList<Noticia> noticies;
	
	// Constr
	public Redactor(String nom, String DNI) {
		this.nom = nom;
		this.DNI = DNI;
		Redactor.sou = 1500; 
		this.noticies = new ArrayList<Noticia>();
	}
	
	// Getters
	public String getNom() {
		return this.nom;
	}
	public String getDNI() {
		return this.DNI;
	}
	public int getSou() {
		return sou;
	}
	public ArrayList<Noticia> getNoticies() {
		return this.noticies;
	}
	
	// Setters
	public void setNom(String nom) {
		this.nom = nom;
	}
	 public void setSou(int nouSalari) { //possibilitat de canviar sou de tots els editors
        Redactor.sou = nouSalari; 
    }
	public void setNoticies(Noticia noticia) {
		this.noticies.add(noticia);
	}
	
	// Own Methods
	@Override
    public String toString() {
        return "Redactor-> Nom: " + this.nom + ", DNI: " + this.DNI +  ", sou: " + sou + ",\n"
        		+ " Notícies publicades: " + this.noticies + ".\n";
    }
}

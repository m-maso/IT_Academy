package n1ex01;

import java.util.ArrayList;

public class Venda {

	// Attrib
	static ArrayList<Producte> productes; //coll. productes
	private float preuTotalV;
	
	// Constr
	public Venda() {
		Venda.productes = new ArrayList<Producte>();
		this.preuTotalV = 0.0f;
	}
	
	// Getters
	public ArrayList<Producte> getProductes() {
		return productes;
	}
	public float getPreuTotalV() {
		return this.preuTotalV;
	}
	
	// Setters
	public void setProductes(Producte producte) {
		Venda.productes.add(producte);
	}

	public void setPreuTotalV(float preuTotalV) {
		this.preuTotalV = preuTotalV;
	}
	
		
	// Grl Method
	public void calcularTotal() throws VendaBuidaException, ArrayIndexOutOfBoundsException {
		
		if(productes.size() == 0) { 
			throw new VendaBuidaException("Per fer una venda primer has d'afegir productes");
		} else if(productes.size() > 2) {
			throw new ArrayIndexOutOfBoundsException("Només pots posar més de 2 items a la compra");
		}
		else {	
			for(int i = 0; i < productes.size(); i++) {
				preuTotalV += productes.get(i).getPreu();
			}
			System.out.println("El preu total de la venda és " + preuTotalV + "€.");
		}
	}
	
	// Own Method
	@Override
	public String toString() {
		return "Venda:\nProductes: " + productes + "\nPreu Total: " + this.preuTotalV + "€";
	}
}


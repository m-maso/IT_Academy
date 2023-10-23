package n1ex01;

public class VendaBuidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String msg = "Per fer una venda primer has d'afegir productes";
	
	public VendaBuidaException(String msg) {
		super(msg);
	}
}

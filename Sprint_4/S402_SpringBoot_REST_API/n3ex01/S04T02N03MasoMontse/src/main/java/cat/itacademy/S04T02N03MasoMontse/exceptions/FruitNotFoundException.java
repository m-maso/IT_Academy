package cat.itacademy.S04T02N03MasoMontse.exceptions;

public class FruitNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FruitNotFoundException(String msg)
	{
		super(msg);
	}
}

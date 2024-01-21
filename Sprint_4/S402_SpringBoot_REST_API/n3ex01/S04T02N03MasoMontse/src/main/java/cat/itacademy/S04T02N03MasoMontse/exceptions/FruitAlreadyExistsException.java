package cat.itacademy.S04T02N03MasoMontse.exceptions;

public class FruitAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FruitAlreadyExistsException(String msg)
	{
		super(msg);
	}
}

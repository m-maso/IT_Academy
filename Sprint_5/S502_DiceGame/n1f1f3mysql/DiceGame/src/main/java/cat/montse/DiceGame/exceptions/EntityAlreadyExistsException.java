package cat.montse.DiceGame.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityAlreadyExistsException(String msg)
	{
		super(msg);
	}
}

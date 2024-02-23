package cat.itacademy.S05T01N01MasoMontse.exceptions;

public class BranchAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BranchAlreadyExistsException(String msg)
	{
		super(msg);
	}
}

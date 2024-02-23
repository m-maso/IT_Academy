package cat.itacademy.S05T01N01MasoMontse.exceptions;

public class BranchNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BranchNotFoundException(String msg)
	{
		super(msg);
	}
}

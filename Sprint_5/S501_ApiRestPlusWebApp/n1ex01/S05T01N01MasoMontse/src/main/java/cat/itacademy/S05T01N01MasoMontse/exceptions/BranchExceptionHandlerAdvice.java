package cat.itacademy.S05T01N01MasoMontse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class BranchExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BranchNotFoundException.class)
	public ResponseEntity<String> branchNotFoundException(BranchNotFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BranchAlreadyExistsException.class)
	public ResponseEntity<String> branchAlreadyExistsException(BranchAlreadyExistsException ex)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.IM_USED);
	}
}

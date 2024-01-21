package cat.itacademy.S04T02N02MasoMontse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



public class FruitExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(FruitNotFoundException.class)
	public ResponseEntity<String> fruitNotFoundException(FruitNotFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FruitAlreadyExistsException.class)
	public ResponseEntity<String> fruitAlreadyExistsException(FruitAlreadyExistsException ex)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.IM_USED);
	}
}

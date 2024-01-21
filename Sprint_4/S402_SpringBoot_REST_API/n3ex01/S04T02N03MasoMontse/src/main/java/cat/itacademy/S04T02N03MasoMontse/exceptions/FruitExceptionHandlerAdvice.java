package cat.itacademy.S04T02N03MasoMontse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class FruitExceptionHandlerAdvice {

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

package n1ex03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class Ex03errorTest {

	Ex03error genError = new Ex03error();
	
	@Test
	public void testingException() {
		assertThrows(ArrayIndexOutOfBoundsException.class, new Executable() {
			@Override
			public void execute() throws ArrayIndexOutOfBoundsException {
				genError.generateErrorArrInd(7);
			}
		});
	}
}

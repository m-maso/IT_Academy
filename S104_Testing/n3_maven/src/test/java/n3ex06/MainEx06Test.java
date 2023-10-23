package n3ex06;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

public class MainEx06Test {

	// Produce ArrayIndexOutOfBoundsException
	int[] list1 = {9,8,7};
	
	// Assertion > validate : throw exception at the right time
	@Test
	public void testingException() {
		assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class).isThrownBy(new ThrowingCallable() {
			@Override
			public void call() throws ArrayIndexOutOfBoundsException {
				System.out.print(list1[3]);
			}
		});
		
	}
}

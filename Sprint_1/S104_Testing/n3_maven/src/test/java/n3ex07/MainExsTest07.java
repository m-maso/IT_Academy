package n3ex07;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import org.junit.Test;

import n3ex01.MainEx01;

public class MainExsTest07 {
	// Uses MainEx01.java to test
	
		
	Optional<MainEx01> objOpt1 = Optional.empty();
	
	@Test
	public void objIsEmpty() {
		assertThat(objOpt1).isEmpty();
	}
}

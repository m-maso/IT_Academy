package n3ex01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MainEx01Test {

	MainEx01 obj1 = new MainEx01(2);
	MainEx01 obj2 = new MainEx01(2);
	MainEx01 obj3 = new MainEx01(5);
	
	// Assertion > demonstrate that the value of 2 int obj is equal
	@Test
	public void sameValue() {
		assertThat(obj1.getValue()).isEqualByComparingTo(obj2.getValue());
	}

	// Assertion > value of 2 int obj is different 
	@Test
	public void diffValue() {
		assertThat(obj1.getValue()).isNotEqualByComparingTo(obj3.getValue());
	}
}

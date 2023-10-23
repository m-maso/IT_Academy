package n3ex02;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import org.junit.Test;

import n3ex01.MainEx01;

public class MainEx02Test {
	// Uses MainEx01.java to test
	
	MainEx01 obj1 = new MainEx01(2);
	MainEx01 obj2 = new MainEx01(2);
	
	// Assertion > 2 obj with same reference
	@Test
	public void sameReference() {
		obj1 = obj2;
		assertSame(obj1, obj2);
	}

	// Assertion > 2 obj with different reference
	@Test
	public void diffReference() {
		assertNotSame(obj1, obj2);
	}
}

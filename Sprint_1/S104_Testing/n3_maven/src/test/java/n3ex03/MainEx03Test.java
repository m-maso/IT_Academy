package n3ex03;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import n3ex01.MainEx01;

public class MainEx03Test {

	// Uses MainEx01.java to test

	MainEx01 list1 = new MainEx01(new int[] {9,8,7});
	MainEx01 list2 = new MainEx01(new int[] {9,8,7});
	
	// Assertion > 2 identical int[] arrays
	@Test
	public void idenArray() {
		assertArrayEquals(list1.getValues(), list2.getValues());
	}
}

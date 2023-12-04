package n3ex05;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.Test;


public class MainExsTestEx05 {

	@Test
	public void isKeyTest() {
		// Create a map
		HashMap<Integer, String> daysW = new HashMap<Integer, String>();
		daysW.put(1,"Monday");
		daysW.put(2, "Tuesday");
		daysW.put(3, "Wednesday");
		daysW.put(4, "Thursday");
		daysW.put(5, "Friday");
		daysW.put(6, "Saturday");
		daysW.put(7, "Sunday");
		
		// Verify one of the keys we add
		assertThat(daysW).containsKey(5);
	}
}

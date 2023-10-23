package n1ex01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MonthsTest {

	/* Check with jUnit that list has 12 positions, that's not null,
	and its 8th position contains 'August' */
	
	Months monthsT = new Months();
		
	@Test
	void is12pos() {
		assertEquals(12, monthsT.getMonths().size());
	}
	
	@Test
	void listNotNull() {
		assertNotNull(monthsT);
	}
	
	@Test
	void isAugPos7() {
		assertEquals("August", monthsT.getMonths().get(7));
	}

}

package n1ex02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculateDniTest {

	/**
	 * @CsvSource allows you to express argument lists as comma-separated values (i.e., CSV String literals). 
	 * Each string provided via the value attribute in @CsvSource represents a CSV record and results in one invocation of the parameterized test.*/
	
	@ParameterizedTest
	@CsvSource({"12345678, Z", "12312312, K", "32165487, X", "98765432, M", "98798765, B",
		"98709876, V", "12398734, D", "43209817, Q", "26498060, J", "100030400, L"})
	
	void isDniCorrect(int dniNum, char letter) {
		char resultLet = CalculateDni.calcDniLetter(dniNum);
		assertEquals(letter, resultLet);
	}

}

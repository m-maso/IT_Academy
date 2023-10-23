package n2ex01;

import org.hamcrest.*;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;

class HamcrestTest {

	public static Matcher<String> strLen(Matcher<? super Integer> matcher) {
		return new FeatureMatcher<String, Integer>(matcher, "string of length", "length") {
			@Override
			protected Integer featureValueOf(String actualWord) {
				return actualWord.length();
			}			
		};
	}
	
	@Test
	public void strLengthTest() {
	    MatcherAssert.assertThat("Mordor", strLen(is(8))); 	//error, because "Mordor" lenght is 6
	    //"Carbassa" it's length 8
//	    MatcherAssert.assertThat("Carbassa", strLen(is(8)));
	}
}
package br.com.lari.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

class DemonRepeatedTest {
	
	SimpleMath math;

	@BeforeEach
	void beforeEachMethod() {
		
		math = new SimpleMath();

		System.out.println("Running @BeforeEach method!");
	}
	
	@RepeatedTest(value = 3, name = "{displayName}. Repetition " + "{currentRepetition} of {totalRepetitions}!")
	@DisplayName("Test Division by zero")
	void testDivision_byZero(
			RepetitionInfo repetitionInfo,
			TestInfo testInfo
			) {
		
		System.out.println("Repetition N " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
		System.out.println("RUnnign " + testInfo.getTestMethod().get().getName());
		
		double secondNumber = 0D;
		double firstNumber = 2D;
		
		var expectedMessage = "Impossible to divide by zero";
		
		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
			math.division(firstNumber, secondNumber);
		},() -> "Division by zero should throw an ArithmeticException" );
		
		assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message!");

	}
}

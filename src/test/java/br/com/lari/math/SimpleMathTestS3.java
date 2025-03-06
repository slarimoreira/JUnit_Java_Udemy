package br.com.lari.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Test Math Operations in SimpleMath")
class SimpleMathTestS3 {
	
	SimpleMath math;
	double firstNumber;
	
	@BeforeAll
	static void setup() {

		System.out.println("Running @BeforeAll method!");
	}
	
	@AfterAll
	static void cleanup() {

		System.out.println("Running @AfterAll method!");
	}
	
	@BeforeEach
	void beforeEachMethod() {
		
		
		
		math = new SimpleMath();
		firstNumber = 6.2D;


		System.out.println("Running @BeforeEach method!");
	}
	
	@AfterEach
	void afterEachMethod() {
		
		math = new SimpleMath();
		firstNumber = 6.2D;

		System.out.println("Running @AfterEach method!");
	}

	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
	void testSum() {
		
		// AAA (3 A) Arrange, Act e Assert
		
		// Given - Arrange		
		double secondNumber = 2D;
		double expected = 8.2D;
		
		
		// When - Act
		
		double actual = math.sum(firstNumber, secondNumber);
		
		// Then - Assert
			
		assertEquals(expected, actual, 
				() -> firstNumber + "+" + secondNumber + "did not produce" + expected );
		
		System.out.println("Test 6.2 + 2 = 8.2");
	}
	
	@Test
	@DisplayName("Test 6.2 - 2 = 4.2")
	void testSubtraction() {
		double secondNumber = 2D;

		double actual = math.subtraction(firstNumber, secondNumber);
		double expected = 4.2D;
		
		assertEquals(expected, actual, 
				() -> firstNumber + "-" + secondNumber + "did not produce" + expected );
		System.out.println("Test 6.2 - 2 = 4.2");
	}
	
	@Test
	@DisplayName("Test 6.2 * 2 = 12.4")
	void testMultiplication() {
		double secondNumber = 2D;
		
		double actual = math.multiplication(firstNumber, secondNumber);
		double expected = 12.4D;
		
		assertEquals(expected, actual, 
				() -> firstNumber + "*" + secondNumber + "did not produce" + expected );
		System.out.println("Test 6.2 * 2 = 12.4");
	}
	
	@Test
	@DisplayName("Test 6.2 / 2 = 3.1")
	void testDivision() {
		
		double secondNumber = 2D;
		double actual = math.division(firstNumber, secondNumber);
		double expected = 3.1D;
		
		assertEquals(expected, actual, 
				() -> firstNumber + "/" + secondNumber + "did not produce" + expected );
		System.out.println("Test 6.2 / 2 = 3.1");
	}

	@Test
	@DisplayName("Test (6.2 + 2)/2 = 4.1")
	void testMean() {
		
		double secondNumber = 2D;
		double actual = math.mean(firstNumber, secondNumber);
		double expected = 4.1D;
		
		assertEquals(expected, actual, 
				() -> "(" + firstNumber + "+" + secondNumber + ")/2" + "did not produce" + expected );
		System.out.println("Test (6.2 + 2)/2 = 4.1");
	}
	

	@Test
	@DisplayName("Test Division by zero")
	void testDivision_byZero() {
		
		double secondNumber = 0D;
		
		var expectedMessage = "Impossible to divide by zero";
		
		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
			math.division(firstNumber, secondNumber);
		},() -> "Division by zero should throw an ArithmeticException" );
		
		assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message!");

	}

}

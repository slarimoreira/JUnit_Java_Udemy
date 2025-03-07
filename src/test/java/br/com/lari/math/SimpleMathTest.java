package br.com.lari.math;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayName("Test Math Operations in SimpleMath")
class SimpleMathTest {
	
	SimpleMath math;
	double firstNumber;

	
	@BeforeEach
	void beforeEachMethod() {
		
		math = new SimpleMath();

		System.out.println("Running @BeforeEach method!");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Pele", "Senna", "Neymar"})
	void testValueSource(String firstName) {
		System.out.println(firstName);
		assertNotNull(firstName);
	}
	
	
	@DisplayName("Test 6.2 / 2 = 3.1")
	@ParameterizedTest
	//@MethodSource("TestDivisionInputParameters")
	//@MethodSource()
	@CsvSource({
		"6.2D, 2D, 3.1D",
		"71D, 14D, 5.07D",
		"18.3D, 3.1D, 5.90D"
	})
	void testDivision(double firstNumber, double secondNumber, double expected) {
		
		
		double actual = math.division(firstNumber, secondNumber);
		
		assertEquals(expected, actual, 2D, 
				() -> firstNumber + "/" + secondNumber + "did not produce" + expected );
	}
	
	/**
	 public static Stream<Arguments> testDivision() {
		 return Stream.of(
				 Arguments.of(6.2D, 2D, 3.1D),
				 Arguments.of(71D, 14D, 5.07D),
				 Arguments.of(18.3D, 3.1D, 5.90D)
			);
	 }
	**/
}

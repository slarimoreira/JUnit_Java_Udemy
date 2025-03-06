package br.com.lari;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class ArraysCompareTest {

	@Test
	void test() {
		int[] numbers = {25,8,21,32,3};
		int[] expectedNumbers = {3,8,21,25,32};
		
		Arrays.sort(numbers);
		
		assertArrayEquals(numbers, expectedNumbers);
	}

	
	@Test
	@Timeout(value = 15, unit = TimeUnit.MICROSECONDS)
	void testSortPerformance() {
		int[] numbers = {25,8,21,32,3};
		for (int i = 0; i < numbers.length; i++) {
			
		}
		
		Arrays.sort(numbers);
		
	}
}

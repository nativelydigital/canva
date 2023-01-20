package com.nativelydigital.canva.round1;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AppTest {
	@Test
	public void shouldAnswerWithTrue() {
		Assertions.assertTrue(true); // JUnit
		assertThat(true, equalTo(true)); // Hamcrest
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	public void positiveNumbersArePositive(int number) {
		assertThat(number, greaterThan(0));
	}
}

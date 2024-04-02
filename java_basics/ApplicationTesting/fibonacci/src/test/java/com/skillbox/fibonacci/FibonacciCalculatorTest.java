package com.skillbox.fibonacci;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciCalculatorTest {
    private static FibonacciCalculator fibonacciCalculator;

    @BeforeAll
    public static void setUp() {
         fibonacciCalculator = new FibonacciCalculator();
    }

    @Test
    @DisplayName("Тест FibonacciCalculator при переданном ВЕРНОМ значенении")
    public void testFibonacciCalculatorTrueValue() {
        assertEquals(55, fibonacciCalculator.getFibonacciNumber(10));
    }
    
    @Test
    @DisplayName("Тест FibonacciCalculator при переданном НЕВЕРНОМ значении")
    public void testFibonacciCalculatorException() {
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacciCalculator.getFibonacciNumber(-1);
        });
    }

    @ParameterizedTest(name = "Тест FibonacciCalculator при переданной 1 или 2")
    @ValueSource(ints = {2,1})
    public void testFibonacciCalculatorValues1And2(int i) {
        assertEquals(1, fibonacciCalculator.getFibonacciNumber(i));
    }







}

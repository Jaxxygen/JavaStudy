package com.skillbox.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FibonacciApplicationTests extends PostgresTestContainerInitializer {

	@Mock
	private final FibonacciRepository repository;
	@Mock
	private final FibonacciCalculator calculator;
    FibonacciApplicationTests(FibonacciRepository repository, FibonacciCalculator calculator) {
        this.repository = repository;
        this.calculator = calculator;
    }

    @Test
	@DisplayName("Тест ")
	void contextLoads() {
	}

}

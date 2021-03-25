package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.sun.tools.doclint.Entity.times;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SpringRestServiceApplicationTests {

	@InjectMocks
	HelloWorldController helloWorldController;

	@Mock
	Message message;

	@Test
	public void sampleTestLeveragingMock() {
		when(message.getMessage()).thenReturn("Message from Mock");

		assertEquals("Message from Mock", message.getMessage());

		System.out.println("Mock output: " + message.getMessage());

		verify(message, times(2)).getMessage();
	}

	@Test
	public void sampleTestLeveragingInjectMocks() {

		when(message.getMessage()).thenReturn("my mock value");

		helloWorldController.greeting(message.getMessage());

		verify(message, times(1)).getMessage();
	}

}

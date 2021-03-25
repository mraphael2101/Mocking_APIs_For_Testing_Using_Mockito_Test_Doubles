package com.example.demo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
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

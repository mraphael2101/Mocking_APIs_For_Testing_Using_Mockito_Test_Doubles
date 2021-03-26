package com.example.demo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

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

		/*
		standaloneSetup(new HelloWorldController());

		given()
				.when()
				.get("/greetings/")
				.then()
				.log().ifValidationFails()
				.statusCode(OK.value())
				.contentType(JSON)
				.body(is(equalTo("[]")));
		 */

		when(message.getMessage()).thenReturn("my mocked value");

		helloWorldController.greeting(message.getMessage());

		verify(message, times(1)).getMessage();

	}

}

package com.example.demo.mockito.testdoubles.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

/* Mockito ArgumentCaptor is used to capture arguments for mocked methods. ArgumentCaptor
   is used with Mockito verify() methods to get the arguments passed when any method is
   called. This way, we can provide additional JUnit assertions for our tests */

public class _03_Captor_Test {

    @BeforeEach
    public void init() {
        // Enable Mockito annotations programmatically
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    List mockedList;

    @Captor
    ArgumentCaptor argCaptor;

    @Test
    public void whenUseCaptorAnnotation_thenTheSame() {
        mockedList.add("one");
        verify(mockedList).add(argCaptor.capture());

        assertEquals("one", argCaptor.getValue());
        System.out.println("argCaptor.getValue() = " + argCaptor.getValue());
    }
}

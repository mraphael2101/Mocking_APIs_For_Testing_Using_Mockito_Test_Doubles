package com.example.demo.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/* Frequently, the final release software consists of a complex set of objects or procedures interacting
together to create the final result. In automated unit testing, it may be necessary to use objects or
procedures that look and behave like their release-intended counterparts, but are actually
simplified versions that reduce the complexity and facilitate testing. A test double is a
generic term used for these objects or procedures. */

/* A mock is a fake implementation of a class used for testing kind of like a test double
   Mocks can implement interfaces and test dependency injection classes so that we can
   inject a mock in there for our unit test  */

public class _01_Mock_Test {

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    List<String> mockedList;

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

}

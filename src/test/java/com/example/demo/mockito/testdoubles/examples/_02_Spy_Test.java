package com.example.demo.mockito.testdoubles.examples;

/* Spies are an easy way to check if a function was called or to provide a custom return
 * value. We can use spies to test components that depend on a service and avoid actually
 * calling the service's methods to get value */

/* A partial mock, allowing you to override select methods of a real class
 * Usually used for heavy weight class when you want to use that class or its specific
 * methods of that real class to mock out */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class _02_Spy_Test {

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    List<String> spiedList = new ArrayList<String>();

    @Test
    public void whenUseSpyAnnotation_thenSpyIsInjectedCorrectly() {
        spiedList.add("one");
        spiedList.add("two");

        verify(spiedList).add("one");
        verify(spiedList).add("two");

        assertEquals(2, spiedList.size());
        doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());
    }

}
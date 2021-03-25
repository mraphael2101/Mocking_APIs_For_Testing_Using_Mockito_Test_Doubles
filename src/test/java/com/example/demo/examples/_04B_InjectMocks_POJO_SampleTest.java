package com.example.demo.examples;

import com.example.demo.data.DatabaseDAO;
import com.example.demo.data.MainClass;
import com.example.demo.data.NetworkDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class _04B_InjectMocks_POJO_SampleTest {

    /*
       - Creates a class instance for the class under test which has a method body that needs to be
         executed, and injects any associated mock dependencies which are required
       - Use this annotation when the class' INTERNAL dependencies must be mocked for the method
         to work correctly
    */

    @InjectMocks
    MainClass mainClass;

    /*
      - Creates an interface to hide a dependency that cannot be tested in a test environment.
        We create mocks for the dependencies which will not be present in the test environment
        and objects are dependent on it to complete the method call
      - We must configure and define the when-thenReturn method(s) combinations for mock objects
        which class methods will be invoking during actual test execution
    */

    // Commenting this out will make this class a real dependency
    @Mock
    DatabaseDAO dependentClassOne;

    // Commenting this out will make this class a real dependency
    @Mock
    NetworkDAO dependentClassTwo;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void validateTest() {
        /* Results in statements being printed which are written in MainClass.save() method, but not
           for dependent classes */
        boolean saved = mainClass.save("temp.txt");
        assertEquals(true, saved);

        /* Prints output:
            Saved in database in Main class
            Saved in network in Main class
          Statements are printed which are written in MainClass.save() method, but not for dependent classes.
          It proves that method body was executed for only MainClass' save method because we created the
          actual object of MainClass using @InjectMocks annotation. For dependent classes we have used mocks
         */

        // Verify that the mock methods have been invoked x times
        verify(dependentClassOne, times(1)).save("temp.txt");
        verify(dependentClassTwo, times(1)).save("temp.txt");
    }
}
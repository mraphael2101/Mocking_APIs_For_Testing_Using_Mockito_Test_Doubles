package com.example.demo.mockito.testdoubles.examples;

import com.example.demo.data.DatabaseDAO;
import com.example.demo.data.MainClass;
import com.example.demo.data.NetworkDAO;
import org.junit.jupiter.api.Test;

public class _04A_Unmocked_POJO_SampleTest {

    DatabaseDAO databaseDAO;
    NetworkDAO networkDAO;

    @Test
    public void realCompIntTest() {
        databaseDAO = new DatabaseDAO();
        networkDAO = new NetworkDAO();

        MainClass mainClass = new MainClass(databaseDAO, networkDAO);
        mainClass.save("madeup.txt");
    }

}

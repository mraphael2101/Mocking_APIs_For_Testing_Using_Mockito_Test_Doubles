package com.example.demo.data;

public class MainClass {

    DatabaseDAO databaseDAO;
    NetworkDAO networkDAO;

    public MainClass(DatabaseDAO databaseDAO, NetworkDAO networkDAO) {
        this.databaseDAO = databaseDAO;
        this.networkDAO = networkDAO;
    }

    public boolean save(String fileName) {
        databaseDAO.save(fileName);
        System.out.println("Saved in database in the Main class");

        networkDAO.save(fileName);
        System.out.println("Saved in network in the Main class");

        return true;
    }

}

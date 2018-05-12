package com.linnyk.jpa.safari;

import org.h2.tools.DeleteDbFiles;
import org.h2.tools.RunScript;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class H2Preparation {

    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        DeleteDbFiles.execute("~", "test", true);
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            RunScript.execute(connection, new FileReader("JPA\\src\\main\\java\\com\\linnyk\\jpa\\safari\\init.sql"));
        } catch (Exception e) {
            System.err.println("Something went wrong while preparation " + e);
        }
    }

}

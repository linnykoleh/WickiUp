package com.linnik.wickiup.patterns._2_structural._2_bridge.live;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author LinnykOleh
 */
public class Live {

    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());

        final String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
        Connection connection = DriverManager.getConnection(dbUrl);

        final Statement statement = connection.createStatement();

        statement.executeUpdate("CREATE TABLE Address (ID INT, Streat VARCHAR(20))");


    }
}

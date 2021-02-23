package pt.iade.ol4s.DAO;

import java.sql.*;

public class DBConnector {



    private static DBConnector connector = null;
    private static final String URL =
            "jdbc:mysql://localhost:3306/ol4s?useSSL=false";
    private static final String PASS = "HT574548?=hf-..TG2";
    private static final String USER = "root";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private DBConnector() {
        try { // 
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DBConnector getConnector() {
        if (connector == null)
            connector = new DBConnector();
        return connector;
    }


    public Connection getConnection() {
        try {
            Connection con = DriverManager.
                    getConnection(URL, USER, PASS);
            return con;
        } catch (SQLException e) {
            System.out.println("Database not found. Check DB URL for errors.");
            e.printStackTrace();

        }
        return null;
    }
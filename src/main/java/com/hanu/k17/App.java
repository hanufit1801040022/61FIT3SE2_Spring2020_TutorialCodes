package com.hanu.k17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public final class App implements Runnable {
    private App() { }

    private static final String CONNECTION_STRING = "jdbc:mysql://127.0.0.1:3306/dbs_study_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root3306";

    public void run() {
        try {
            DriverManager.registerDriver(new Driver());
            Connection conn = createConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery("SELECT student_id as id, OVR as ovr FROM possible_scholarship_earners_k17");
            while (result.next()) {
                System.out.println("ID: " + result.getInt("id") + ", ovr: " + result.getDouble("ovr"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Connection createConnection(String connectionString, String username, String password) throws SQLException {
        return DriverManager.getConnection(connectionString, username, password);
    }

    public static void main(String[] args) {
        new App().run();
    }
}

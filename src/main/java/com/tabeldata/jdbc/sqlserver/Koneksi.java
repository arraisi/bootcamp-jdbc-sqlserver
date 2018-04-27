package com.tabeldata.jdbc.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    public static Connection getKoneksiKeDB() throws SQLException {
        String username = "sa";
        String URL = "jdbc:sqlserver://localhost:1433;databaseName=JDBC_DIMAS;";
        String password = "PasswordnyaSA2018";
        return DriverManager.getConnection(URL, username, password);
    }

    public static void main(String[] args) throws SQLException {

    }
}

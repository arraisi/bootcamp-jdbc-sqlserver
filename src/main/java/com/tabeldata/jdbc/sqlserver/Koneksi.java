package com.tabeldata.jdbc.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    //    format jdbc url yaitu jdbc:sqlserver://LOKASI_DATABASE:PORT_DATABASE;databaseName=NAMA_DATABASE
    private static final String URL = "jdbc:sqlserver://192.168.100.50:1433;databaseName=JDBC_DIMAS;";
    private static final String username = "sa";
    private static final String password = "PasswordnyaSA2018";

    public static void main(String[] args) throws SQLException {

//        try {
//            // untuk membuat koneksi ke database
//            Connection connection = DriverManager.getConnection(URL, username, password);
//            System.out.println("Database terkoneksi");
//        } catch (SQLException sqle) {
//            // handling ketika terjadi error koneksi ke database
////            sqle.printStackTrace();
//            System.out.println("Tidak dapat koneksi ke database kerena username atau password salah");
//        }

        Connection connection = DriverManager.getConnection(URL, username, password);

    }
}

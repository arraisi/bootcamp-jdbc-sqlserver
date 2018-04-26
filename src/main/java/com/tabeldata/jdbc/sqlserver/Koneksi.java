package com.tabeldata.jdbc.sqlserver;

import java.sql.*;

public class Koneksi {

    // if database server on windows jdbc:sqlserver://LOKASI_DATABASE:PORT_DATABASE;databaseName=NAMA_DATABASE;instanceName=SQLSERVER2017;
    //    format jdbc url yaitu jdbc:sqlserver://LOKASI_DATABASE:PORT_DATABASE;databaseName=NAMA_DATABASE
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=JDBC_DIMAS;";
    private static final String username = "sa";
    private static final String password = "PasswordnyaSA2018";

    public static void main(String[] args) throws SQLException {

        Connection koneksi = DriverManager.getConnection(URL, username, password);
        PreparedStatement perintah = koneksi.prepareStatement("update Buku\n" +
                "set NAMA_PENGARANG = ?, LAST_UPDATE_DATE = sysdatetime(), UPDATED_BY = ?\n" +
                "where ID = ?");
        perintah.setString(1, "Dimas Maryanto");
        perintah.setString(2, "OP");
        perintah.setInt(3, 2);
        perintah.executeUpdate();
        perintah.close();
        koneksi.close();
    }
}

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
        PreparedStatement perintah = koneksi.prepareStatement("insert into Buku ( JUDUL_BUKU, NAMA_PENGARANG, PENERBIT_ID, TAHUN_TERBIT, TANGGAL_PUBLISH, ISBN, TERSEDIA, CREATED_DATE, LAST_UPDATE_DATE, CREATED_BY, UPDATED_BY)\n" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, null, ?, null);");
        perintah.setString(1, "PHP Programing");
        perintah.setString(2, "Putri");
        perintah.setInt(3, 1);
        perintah.setInt(4, 2017);
        perintah.setDate(5, Date.valueOf("2017-08-20"));
        perintah.setString(6, "1234-12345-2343435");
        perintah.setBoolean(7, true);
        perintah.setTimestamp(8, Timestamp.valueOf("2017-03-10 10:00:00"));
        perintah.setString(9, "OP");
        perintah.executeUpdate();
        perintah.close();
        koneksi.close();
    }
}

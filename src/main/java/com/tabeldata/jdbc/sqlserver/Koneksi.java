package com.tabeldata.jdbc.sqlserver;

import java.sql.*;

public class Koneksi {

    // if database server on windows jdbc:sqlserver://LOKASI_DATABASE:PORT_DATABASE;databaseName=NAMA_DATABASE;instanceName=SQLSERVER2017;
    //    format jdbc url yaitu jdbc:sqlserver://LOKASI_DATABASE:PORT_DATABASE;databaseName=NAMA_DATABASE
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=JDBC_DIMAS;";
    private static final String username = "sa";
    private static final String password = "PasswordnyaSA2018";

    public static void main(String[] args) {

        Connection koneksi = null;
        try {
            koneksi = DriverManager.getConnection(URL, username, password);
//        transactional auto commit dimatikan
            koneksi.setAutoCommit(false);
            PreparedStatement perintah = koneksi.prepareStatement("update Buku\n" +
                    "set NAMA_PENGARANG = ?, LAST_UPDATE_DATE = sysdatetime(), UPDATED_BY = ?\n" +
                    "where ID = ?");
            perintah.setString(1, "Dimas");
            perintah.setString(2, "OP1");
            perintah.setInt(3, 2);
            perintah.executeUpdate();

            perintah = koneksi.prepareStatement("update Buku\n" +
                    "set TAHUN_TERBIT = ?, LAST_UPDATE_DATE = sysdatetime(), UPDATED_BY = ?\n" +
                    "where ID = ?");
            perintah.setInt(1, 2011);
            perintah.setString(2, "OP");
            perintah.setInt(3, 2);
            perintah.executeUpdate();

//      simpan data secara permanen
            koneksi.commit();
            System.out.println("Berhasil di update!");
            perintah.close();
            koneksi.close();
        } catch (SQLException sqle) {
            if (koneksi != null) {
                try {
                    koneksi.rollback();
                    System.out.println("Rollback berhasil!");
                } catch (SQLException sqle2) {
                    System.out.println("Tidak dapat melakukan rollback");
                    sqle2.printStackTrace();
                }
            }
        }
    }
}

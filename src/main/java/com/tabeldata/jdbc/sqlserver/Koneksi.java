package com.tabeldata.jdbc.sqlserver;

import java.sql.*;

public class Koneksi {

    // if database server on windows jdbc:sqlserver://LOKASI_DATABASE:PORT_DATABASE;databaseName=NAMA_DATABASE;instanceName=SQLSERVER2017;
    //    format jdbc url yaitu jdbc:sqlserver://LOKASI_DATABASE:PORT_DATABASE;databaseName=NAMA_DATABASE
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=JDBC_DIMAS;";
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

        Connection koneksi = DriverManager.getConnection(URL, username, password);
        PreparedStatement perintah = koneksi.prepareStatement("select ID, JUDUL_BUKU, NAMA_PENGARANG, ISBN from Buku where ID = ? and NAMA_PENGARANG like ?");
        perintah.setInt(1, 1);
        perintah.setString(2, "Dimas");
        ResultSet resultSet = perintah.executeQuery();
//        ambil data per baris
        while (resultSet.next()) {
            String namaPengarang = resultSet.getString("NAMA_PENGARANG");
            String judulBuku = resultSet.getString("JUDUL_BUKU");
            String isbn = resultSet.getString(4);
            Integer id = resultSet.getInt(1);

            System.out.println("namaPengarang : " + namaPengarang + ", judulBuku: " + judulBuku + ", isbn: " + isbn);
        }
        resultSet.close();
        perintah.close();
        koneksi.close();
    }
}

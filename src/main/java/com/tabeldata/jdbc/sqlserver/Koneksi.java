package com.tabeldata.jdbc.sqlserver;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Koneksi {

    // if database server on windows jdbc:sqlserver://LOKASI_DATABASE:PORT_DATABASE;databaseName=NAMA_DATABASE;instanceName=SQLSERVER2017;
    //    format jdbc url yaitu jdbc:sqlserver://LOKASI_DATABASE:PORT_DATABASE;databaseName=NAMA_DATABASE
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=JDBC_DIMAS;";
    private static final String username = "sa";
    private static final String password = "PasswordnyaSA2018";

    public static void main(String[] args) {

        List<String> daftarKatogori = Arrays.asList("Pemograman", "Ilmu Komputer Dasar", "Networking", "Sastra", "Fisika", "Elektro");

        Connection koneksi = null;
        try {
            koneksi = DriverManager.getConnection(URL, username, password);
//        transactional auto commit dimatikan
            koneksi.setAutoCommit(false);

            String sql = "insert into JDBC_DIMAS.dbo.Kategori( NAMA_KATEGORI) values (?)";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            for(String value : daftarKatogori){
                perintah.setString(1, value);
                perintah.addBatch();
            }
            perintah.executeBatch();
//            required supaya cache di prosessor di bersikan
            perintah.clearBatch();

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

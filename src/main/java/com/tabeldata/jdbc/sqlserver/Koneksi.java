package com.tabeldata.jdbc.sqlserver;

import com.tabeldata.jdbc.sqlserver.model.Buku;
import com.tabeldata.jdbc.sqlserver.service.BukuService;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Koneksi {

    // if database server on windows jdbc:sqlserver://LOKASI_DATABASE:PORT_DATABASE;databaseName=NAMA_DATABASE;instanceName=SQLSERVER2017;
    //    format jdbc url yaitu jdbc:sqlserver://LOKASI_DATABASE:PORT_DATABASE;databaseName=NAMA_DATABASE

    public static Connection getKoneksiKeDB() throws SQLException {
        String username = "sa";
        String URL = "jdbc:sqlserver://localhost:1433;databaseName=JDBC_DIMAS;";
        String password = "PasswordnyaSA2018";
        return DriverManager.getConnection(URL, username, password);
    }



    public static void main(String[] args) throws SQLException {

//        List<String> daftarKatogori = Arrays.asList("Pemograman", "Ilmu Komputer Dasar", "Networking", "Sastra", "Fisika", "Elektro");
        BukuService serviceBuku = new BukuService();
        serviceBuku.saveData(new Buku("Spiderman", "asdfkj", 1, 2017, Date.valueOf("2018-10-03"), "23423423-234234-234324", false));

    }
}

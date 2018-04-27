package com.tabeldata.jdbc.sqlserver;

import com.tabeldata.jdbc.sqlserver.model.AngsuranKredit;
import com.tabeldata.jdbc.sqlserver.model.Nasabah;
import com.tabeldata.jdbc.sqlserver.repository.AngsuranKreditRepository;
import com.tabeldata.jdbc.sqlserver.repository.NasabahRepository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Koneksi {

    public static Connection getKoneksiKeDB() throws SQLException {
        String username = "sa";
        String URL = "jdbc:sqlserver://localhost:1433;databaseName=JDBC_DIMAS;";
        String password = "PasswordnyaSA2018";
        return DriverManager.getConnection(URL, username, password);
    }

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        Nasabah nasabah = new Nasabah();
        System.out.println("input nama nasabah : ");
        nasabah.setNamaNasabah(input.nextLine());
        System.out.println("input jumlah pinjaman : ");
        nasabah.setPinjaman(new BigDecimal(input.nextLine()));
        System.out.println("input tenor : ");
        nasabah.setTenor(Integer.valueOf(input.nextLine()));
        System.out.println("input bunga per tahun : ");
        nasabah.setBungaPerAnum(Double.valueOf(input.nextLine()));

        Connection connection = getKoneksiKeDB();
        connection.setAutoCommit(false);
        NasabahRepository nasabahRepository = new NasabahRepository(connection);
        nasabahRepository.saveNasabah(nasabah);

        List<AngsuranKredit> listAngsuran = new ArrayList<>();
        for (int i = 1; i <= nasabah.getTenor(); i++) {
            AngsuranKredit angsuran = new AngsuranKredit();
            angsuran.setAngsuranKe(i);
            angsuran.setBunga(BigDecimal.ZERO);
            angsuran.setJumlah(BigDecimal.ZERO);
            angsuran.setSisa(BigDecimal.ZERO);
            angsuran.setPokok(BigDecimal.ZERO);
            angsuran.setNasabah(nasabah);
            listAngsuran.add(angsuran);
        }
        AngsuranKreditRepository kreditRepository = new AngsuranKreditRepository(connection);
        kreditRepository.saveListAngsuranKredit(listAngsuran);
        connection.commit();

        nasabah = nasabahRepository.getNasabahById(nasabah.getId());
        System.out.println(nasabah.toString());

        nasabah.getListAngsuran().forEach((angsuranKredit) -> {
                    System.out.println(angsuranKredit.toString());
                }
        );
        connection.close();

    }
}

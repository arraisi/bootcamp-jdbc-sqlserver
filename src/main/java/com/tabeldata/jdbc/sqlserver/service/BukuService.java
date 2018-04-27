package com.tabeldata.jdbc.sqlserver.service;

import com.tabeldata.jdbc.sqlserver.Koneksi;
import com.tabeldata.jdbc.sqlserver.model.Buku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BukuService {

    public Buku saveData(Buku buku) throws SQLException {
        Connection koneksi = Koneksi.getKoneksiKeDB();
        PreparedStatement perintah = koneksi.prepareStatement("insert into Buku ( JUDUL_BUKU, NAMA_PENGARANG, PENERBIT_ID, TAHUN_TERBIT, TANGGAL_PUBLISH, ISBN, TERSEDIA, CREATED_DATE, LAST_UPDATE_DATE, CREATED_BY, UPDATED_BY)\n" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, null, ?, null);");
        perintah.setString(1, buku.getJudulBuku());
        perintah.setString(2, buku.getNamaPengarang());
        perintah.setInt(3, buku.getPenerbitId().getId());
        perintah.setInt(4, buku.getTahunTerbit());
        perintah.setDate(5, buku.getTanggalPublish());
        perintah.setString(6, buku.getIbsn());
        perintah.setBoolean(7, buku.getTersedian());
        perintah.setTimestamp(8, buku.getCreatedDate());
        perintah.setString(9, buku.getCreatedBy());
        perintah.executeUpdate();
        perintah.close();
        koneksi.close();
        return buku;
    }
}

package com.tabeldata.jdbc.sqlserver.repository;

import com.tabeldata.jdbc.sqlserver.model.AngsuranKredit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AngsuranKreditRepository {

    private final Connection connection;

    public AngsuranKreditRepository(Connection connection) {
        this.connection = connection;
    }

    public void saveListAngsuranKredit(List<AngsuranKredit> list) throws SQLException {
        String query = "INSERT INTO JDBC_DIMAS.kredit.AngsuranKredit(AngsuranKe, NasabahId, PokokPinjaman, BungaAngsuran, SisaAngsuran, JumlahAngsuran) values (?, ?, ?, ?,? ,?)";

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        for (AngsuranKredit angsuran : list) {
            preparedStatement.setInt(1, angsuran.getAngsuranKe());
            preparedStatement.setInt(2, angsuran.getNasabah().getId());
            preparedStatement.setBigDecimal(3, angsuran.getPokok());
            preparedStatement.setBigDecimal(4, angsuran.getBunga());
            preparedStatement.setBigDecimal(5, angsuran.getSisa());
            preparedStatement.setBigDecimal(6, angsuran.getJumlah());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        preparedStatement.clearBatch();
        preparedStatement.close();
    }

    public List<AngsuranKredit> getListAngsuranByNasabahId(Integer id) throws SQLException {
        List<AngsuranKredit> list = new ArrayList<>();
        //language=TSQL
        String query = "select *\n" +
                "from JDBC_DIMAS.kredit.AngsuranKredit\n" +
                "where NasabahId = ?\n" +
                "order by AngsuranKe asc ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            AngsuranKredit kredit = new AngsuranKredit();
            kredit.setId(resultSet.getInt("id"));
            kredit.setAngsuranKe(resultSet.getInt("AngsuranKe"));
            kredit.setPokok(resultSet.getBigDecimal("PokokPinjaman"));
            kredit.setBunga(resultSet.getBigDecimal("BungaAngsuran"));
            kredit.setSisa(resultSet.getBigDecimal("SisaAngsuran"));
            kredit.setJumlah(resultSet.getBigDecimal("JumlahAngsuran"));
            list.add(kredit);
//            kredit.setNasabah(resultSet.getInt("id"));
        }
        resultSet.close();
        preparedStatement.close();
        return list;
    }
}

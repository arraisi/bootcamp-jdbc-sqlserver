package com.tabeldata.jdbc.sqlserver.repository;

import com.tabeldata.jdbc.sqlserver.model.Nasabah;

import java.sql.*;

public class NasabahRepository {

    private final Connection connection;

    public NasabahRepository(Connection connection) {
        this.connection = connection;
    }

    public Nasabah saveNasabah(Nasabah nasabah) throws SQLException {
        String query = "insert into JDBC_DIMAS.kredit.Nasabah(NamaNasabah, pinjaman, tenor, bungaPerAnum) values (?, ?, ?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, nasabah.getNamaNasabah());
        preparedStatement.setBigDecimal(2, nasabah.getPinjaman());
        preparedStatement.setInt(3, nasabah.getTenor());
        preparedStatement.setDouble(4, nasabah.getBungaPerAnum());
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            nasabah.setId(resultSet.getInt(1));
        }
        resultSet.close();
        preparedStatement.close();
        return nasabah;
    }

    public Nasabah getNasabahById(Integer id) throws SQLException {
        Nasabah nasabah = new Nasabah();
        String query = "select\n" +
                "  id,\n" +
                "  NamaNasabah,\n" +
                "  pinjaman,\n" +
                "  tenor,\n" +
                "  bungaPerAnum\n" +
                "from JDBC_DIMAS.kredit.Nasabah\n" +
                "where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            nasabah.setId(resultSet.getInt("id"));
            nasabah.setNamaNasabah(resultSet.getString("NamaNasabah"));
            nasabah.setPinjaman(resultSet.getBigDecimal("pinjaman"));
            nasabah.setTenor(resultSet.getInt("tenor"));
            nasabah.setBungaPerAnum(resultSet.getDouble("bungaPerAnum"));
            nasabah.setListAngsuran(new AngsuranKreditRepository(connection).getListAngsuranByNasabahId(nasabah.getId()));
        }
        resultSet.close();
        preparedStatement.close();

        return nasabah;
    }
}

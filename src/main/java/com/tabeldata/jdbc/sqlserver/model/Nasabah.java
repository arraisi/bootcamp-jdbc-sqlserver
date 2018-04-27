package com.tabeldata.jdbc.sqlserver.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Nasabah {

    public Nasabah() {

    }

    public Nasabah(String namaNasabah, BigDecimal pinjaman, Integer tenor, Double bungaPerAnum) {
        this.namaNasabah = namaNasabah;
        this.pinjaman = pinjaman;
        this.tenor = tenor;
        this.bungaPerAnum = bungaPerAnum;
    }

    private Integer id;
    private String namaNasabah;
    private BigDecimal pinjaman;
    private Integer tenor;
    private Double bungaPerAnum;
    private List<AngsuranKredit> listAngsuran = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    public BigDecimal getPinjaman() {
        return pinjaman;
    }

    public void setPinjaman(BigDecimal pinjaman) {
        this.pinjaman = pinjaman;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }

    public Double getBungaPerAnum() {
        return bungaPerAnum;
    }

    public void setBungaPerAnum(Double bungaPerAnum) {
        this.bungaPerAnum = bungaPerAnum;
    }

    public List<AngsuranKredit> getListAngsuran() {
        return listAngsuran;
    }

    public void setListAngsuran(List<AngsuranKredit> listAngsuran) {
        this.listAngsuran = listAngsuran;
    }

    @Override
    public String toString() {
        return "nama nasabah: " + namaNasabah + ", jumlah pinjaman: " + pinjaman + ", tenor: " + tenor + ", bunga: " + bungaPerAnum;
    }
}

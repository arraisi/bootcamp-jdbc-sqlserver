package com.tabeldata.jdbc.sqlserver.model;

import java.math.BigDecimal;

public class AngsuranKredit {

    private Integer id;
    private Integer angsuranKe;
    private Nasabah nasabah;
    private BigDecimal pokok;
    private BigDecimal bunga;
    private BigDecimal sisa;
    private BigDecimal jumlah;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAngsuranKe() {
        return angsuranKe;
    }

    public void setAngsuranKe(Integer angsuranKe) {
        this.angsuranKe = angsuranKe;
    }

    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    public BigDecimal getPokok() {
        return pokok;
    }

    public void setPokok(BigDecimal pokok) {
        this.pokok = pokok;
    }

    public BigDecimal getBunga() {
        return bunga;
    }

    public void setBunga(BigDecimal bunga) {
        this.bunga = bunga;
    }

    public BigDecimal getSisa() {
        return sisa;
    }

    public void setSisa(BigDecimal sisa) {
        this.sisa = sisa;
    }

    public BigDecimal getJumlah() {
        return jumlah;
    }

    public void setJumlah(BigDecimal jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "|" + angsuranKe + "|" + pokok + "|" + bunga + "|" + sisa + "|" + jumlah;
    }
}

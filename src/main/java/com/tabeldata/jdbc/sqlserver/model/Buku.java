package com.tabeldata.jdbc.sqlserver.model;

import com.sun.tools.corba.se.idl.constExpr.Times;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Buku {

    public Buku() {
    }

    public Buku(String judulBuku, String namaPengarang, Integer idPenerbit, Integer tahunTerbit, Date tanggalPublish,
                String isbn, Boolean tersedia) {
        this.judulBuku = judulBuku;
        this.namaPengarang = namaPengarang;
        this.penerbitId = new Penerbit();
        this.penerbitId.setId(idPenerbit);

        this.tahunTerbit = tahunTerbit;
        this.tanggalPublish = tanggalPublish;
        this.ibsn = isbn;
        this.tersedian = tersedia;
        this.createdDate = Timestamp.valueOf(LocalDateTime.now());
        this.createdBy = "OP";
    }


    private Integer id;
    private String judulBuku;
    private String namaPengarang;
    private Penerbit penerbitId;
    private Integer tahunTerbit;
    private Date tanggalPublish;
    private String ibsn;
    private Boolean tersedian;
    private Timestamp createdDate;
    private Times lastUpdateDate;
    private String createdBy;
    private String updateBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public Penerbit getPenerbitId() {
        return penerbitId;
    }

    public void setPenerbitId(Penerbit penerbitId) {
        this.penerbitId = penerbitId;
    }

    public Integer getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(Integer tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public Date getTanggalPublish() {
        return tanggalPublish;
    }

    public void setTanggalPublish(Date tanggalPublish) {
        this.tanggalPublish = tanggalPublish;
    }

    public String getIbsn() {
        return ibsn;
    }

    public void setIbsn(String ibsn) {
        this.ibsn = ibsn;
    }

    public Boolean getTersedian() {
        return tersedian;
    }

    public void setTersedian(Boolean tersedian) {
        this.tersedian = tersedian;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Times getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Times lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getNamaPengarang() {
        return namaPengarang;
    }

    public void setNamaPengarang(String namaPengarang) {
        this.namaPengarang = namaPengarang;
    }
}

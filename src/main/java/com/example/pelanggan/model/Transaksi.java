package com.example.pelanggan.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Transaksi {
    @JsonView({lihat.viewdetail.class,lihat.viewlist.class,lihat.viewTransaksi.class})
    private int idTransaksi;
    @JsonView()
    private int harga;
    @JsonView({lihat.viewdetail.class})
    private Date tglTransaksi;
    private Integer idPelanggan;
    @JsonView({lihat.viewTransaksi.class})
    private Pelanggan pelangganByIdPelanggan;

    @Id
    @Column(name = "id_transaksi")
    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    @Basic
    @Column(name = "harga")
    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Basic
    @Column(name = "tgl_transaksi")
    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    @Basic
    @Column(name = "id_pelanggan")
    public Integer getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(Integer idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaksi transaksi = (Transaksi) o;
        return idTransaksi == transaksi.idTransaksi &&
                harga == transaksi.harga &&
                Objects.equals(tglTransaksi, transaksi.tglTransaksi) &&
                Objects.equals(idPelanggan, transaksi.idPelanggan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaksi, harga, tglTransaksi, idPelanggan);
    }

    @ManyToOne
    @JoinColumns(@JoinColumn(name = "id_pelanggan", referencedColumnName = "id", nullable = false, insertable = false, updatable = false))
    public Pelanggan getPelangganByIdPelanggan() {
        return pelangganByIdPelanggan;
    }

    public void setPelangganByIdPelanggan(Pelanggan pelangganByIdPelanggan) {
        this.pelangganByIdPelanggan = pelangganByIdPelanggan;
    }
}

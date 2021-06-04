package com.example.pelanggan.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Pelanggan {
    @JsonView({lihat.viewlist.class, lihat.viewdetail.class,lihat.viewTransaksi.class})
    private int id;
    @JsonView({lihat.viewlist.class, lihat.viewdetail.class})
    private String nama;
    @JsonView(lihat.viewdetail.class)
    private String alamat;
    @JsonView(lihat.viewdetail.class)
    private int jenis;
    @JsonView({lihat.viewlist.class, lihat.viewdetail.class})
    private Typepelanggan typepelangganByJenis;
    @JsonView(lihat.viewdetail.class)
    private Boolean stat;

    @JsonView({lihat.viewdetail.class})
    private Collection<Transaksi> transaksisById;
    private String password;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nama")
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Basic
    @Column(name = "alamat")
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelanggan pelanggan = (Pelanggan) o;
        return id == pelanggan.id &&
                Objects.equals(nama, pelanggan.nama) &&
                Objects.equals(alamat, pelanggan.alamat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nama, alamat);
    }

    @Basic
    @Column(name = "jenis")
    public int getJenis() {
        return jenis;
    }

    public void setJenis(int jenis) {
        this.jenis = jenis;
    }

    @ManyToOne
    @JoinColumn(name = "jenis", referencedColumnName = "id_type", nullable = false, insertable = false, updatable = false)
    public Typepelanggan getTypepelangganByJenis() {
        return typepelangganByJenis;
    }

    public void setTypepelangganByJenis(Typepelanggan typepelangganByJenis) {
        this.typepelangganByJenis = typepelangganByJenis;
    }

    @Basic
    @Column(name = "stat")
    public Boolean getStat() {
        return stat;
    }

    public void setStat(Boolean stat) {
        this.stat = stat;
    }

    @OneToMany(mappedBy = "pelangganByIdPelanggan")
    public Collection<Transaksi> getTransaksisById() {
        return transaksisById;
    }

    public void setTransaksisById(Collection<Transaksi> transaksisById) {
        this.transaksisById = transaksisById;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.example.pelanggan.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Typepelanggan {
    @JsonView({lihat.viewdetail.class,lihat.viewlist.class,lihat.viewJenis.class,lihat.viewMaster.class})
    private int idType;
    @JsonView({lihat.viewlist.class, lihat.viewdetail.class,lihat.viewJenis.class,lihat.viewMaster.class})
    private String namaType;
    private Collection<Pelanggan> pelanggansByIdType;
   @JsonView({lihat.viewlist.class,lihat.viewJenis.class})
    private Mastertype mastertypeByMaster;
    private Integer master;

    @Id
    @Column(name = "id_type")
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "nama_type")
    public String getNamaType() {
        return namaType;
    }

    public void setNamaType(String namaType) {
        this.namaType = namaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Typepelanggan that = (Typepelanggan) o;
        return idType == that.idType &&
                Objects.equals(namaType, that.namaType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, namaType);
    }

    @OneToMany(mappedBy = "typepelangganByJenis")
    public Collection<Pelanggan> getPelanggansByIdType() {
        return pelanggansByIdType;
    }

    public void setPelanggansByIdType(Collection<Pelanggan> pelanggansByIdType) {
        this.pelanggansByIdType = pelanggansByIdType;
    }

    @Basic
    @Column(name = "master")
    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

    @ManyToOne
    @JoinColumn(name = "master", referencedColumnName = "id_master", nullable = false, insertable = false, updatable = false)
    @JsonView({lihat.viewlist.class,lihat.viewJenis.class})
    public Mastertype getMastertypeByMaster() {
        return mastertypeByMaster;
    }

    public void setMastertypeByMaster(Mastertype mastertypeByMaster) {
        this.mastertypeByMaster = mastertypeByMaster;
    }

}

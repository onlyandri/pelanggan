package com.example.pelanggan.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Mastertype {
    @JsonView({lihat.viewdetail.class,
            lihat.viewlist.class,
            lihat.viewTransaksi.class,
            lihat.viewJenis.class,
            lihat.viewMaster.class})
    private int idMaster;
    @JsonView({lihat.viewdetail.class,
            lihat.viewlist.class,
            lihat.viewTransaksi.class,
            lihat.viewJenis.class,lihat.viewMaster.class})
    private String namaMaster;
    @JsonView({lihat.viewMaster.class})
    private Collection<Typepelanggan> typepelanggansByIdMaster;

    @Id
    @Column(name = "id_master")
    public int getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(int idMaster) {
        this.idMaster = idMaster;
    }

    @Basic
    @Column(name = "nama_master")
    public String getNamaMaster() {
        return namaMaster;
    }

    public void setNamaMaster(String namaMaster) {
        this.namaMaster = namaMaster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mastertype that = (Mastertype) o;
        return idMaster == that.idMaster &&
                Objects.equals(namaMaster, that.namaMaster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMaster, namaMaster);
    }

    @OneToMany(mappedBy = "mastertypeByMaster")
    public Collection<Typepelanggan> getTypepelanggansByIdMaster() {
        return typepelanggansByIdMaster;
    }

    public void setTypepelanggansByIdMaster(Collection<Typepelanggan> typepelanggansByIdMaster) {
        this.typepelanggansByIdMaster = typepelanggansByIdMaster;
    }
}

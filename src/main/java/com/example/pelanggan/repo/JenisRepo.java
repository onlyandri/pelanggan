package com.example.pelanggan.repo;

import com.example.pelanggan.model.Typepelanggan;

import java.lang.reflect.Type;
import java.util.List;

public interface JenisRepo {
    List<Typepelanggan> getAll();
    void Tambah(Typepelanggan a);
    void update(Typepelanggan a);
    Typepelanggan get(int id);
    void delete(Typepelanggan a);
    List<Typepelanggan> getByName(String nama);
    List<Typepelanggan> getByIdMaster(int idMaster);
}

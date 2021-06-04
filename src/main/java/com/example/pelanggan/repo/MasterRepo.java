package com.example.pelanggan.repo;

import com.example.pelanggan.model.Mastertype;

import java.util.List;

public interface MasterRepo {
    List<Mastertype> getAll();
    void tambah (Mastertype a);
    void update(Mastertype a);
    Mastertype get(int id);
    void delete(Mastertype a);
    List<Mastertype> getByName(String nama);
}

package com.example.pelanggan.repo;

import com.example.pelanggan.model.Pelanggan;
import com.example.pelanggan.model.Transaksi;

import java.util.List;

public interface PelangganRepo {
    List<Pelanggan> getall();
    void tambah (Pelanggan a);
    void update(Pelanggan a);
    Pelanggan get(int id);
    void delete(int id);
    List<Transaksi> getByName(String nama);
    Object getByNamePassword(String nama, String password);
}

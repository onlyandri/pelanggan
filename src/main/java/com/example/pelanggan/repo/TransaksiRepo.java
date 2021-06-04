package com.example.pelanggan.repo;

import com.example.pelanggan.model.Transaksi;

import java.util.List;

public interface TransaksiRepo {

    List<Transaksi> getALL();
    void Tambah(Transaksi a);
    void Update(Transaksi a);
    Transaksi get(int id_transaksi);
    void delete(Transaksi a);
    List<Transaksi> getByIdPelanggan(int id_pelanggan);
}

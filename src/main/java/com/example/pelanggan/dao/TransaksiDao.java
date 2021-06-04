package com.example.pelanggan.dao;

import com.example.pelanggan.model.Transaksi;
import com.example.pelanggan.repo.TransaksiRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TransaksiDao implements TransaksiRepo {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Transaksi> getALL() {
        return entityManager.createQuery("from Transaksi ").getResultList();
    }

    @Override
    public void Tambah(Transaksi a) {
        entityManager.persist(a);
        entityManager.flush();
    }

    @Override
    public void Update(Transaksi a) {
        Transaksi t = get(a.getIdTransaksi());
        t.setHarga(a.getHarga());
        t.setIdPelanggan(a.getIdPelanggan());
        t.setTglTransaksi(a.getTglTransaksi());
        entityManager.flush();
    }

    @Override
    public Transaksi get(int id_transaksi) {
        return entityManager.find(Transaksi.class, id_transaksi);
    }

    @Override
    public void delete(Transaksi a) {
            entityManager.remove(get(a.getIdTransaksi()));
    }

    @Override
    public List getByIdPelanggan(int id_pelanggan) {
       return entityManager.createQuery(" from Transaksi where id_pelanggan=:idPelanggan").setParameter("idPelanggan",id_pelanggan).getResultList();
    }
}

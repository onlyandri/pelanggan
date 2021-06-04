package com.example.pelanggan.dao;

import com.example.pelanggan.model.Transaksi;
import com.example.pelanggan.model.Typepelanggan;
import com.example.pelanggan.model.lihat;
import com.example.pelanggan.repo.JenisRepo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class JenisDao implements JenisRepo {
    @PersistenceContext
   private  EntityManager entityManager;
    @Override
    public List<Typepelanggan> getAll() {
        return entityManager.createQuery("from Typepelanggan ").getResultList();
    }

    @Override
    public void Tambah(Typepelanggan a) {
        entityManager.persist(a);
        entityManager.flush();
    }

    @Override
    public void update(Typepelanggan a) {
        Typepelanggan t = get(a.getIdType());
        t.setNamaType(a.getNamaType());
        t.setMastertypeByMaster(a.getMastertypeByMaster());
        entityManager.flush();
    }

    @Override
    public Typepelanggan get(int id) {
        return entityManager.find(Typepelanggan.class, id);
    }

    @Override
    public void delete(Typepelanggan a) {
        entityManager.remove(get(a.getIdType()));
    }

    @Override
    public List<Typepelanggan> getByName(String nama) {
        return null;
    }

    @Override
    public List<Typepelanggan> getByIdMaster(int idMaster) {
        return entityManager.createQuery(" from Typepelanggan a where a.master=:id")
                .setParameter("id",idMaster).getResultList();
    }
}

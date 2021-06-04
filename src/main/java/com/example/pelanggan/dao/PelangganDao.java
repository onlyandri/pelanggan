package com.example.pelanggan.dao;

import com.example.pelanggan.model.Pelanggan;
import com.example.pelanggan.model.Transaksi;
import com.example.pelanggan.repo.PelangganRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PelangganDao implements PelangganRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getall() {
        return entityManager.createQuery("from Pelanggan order by id desc").getResultList();

    }

    @Override
    public void tambah(Pelanggan a) {
        entityManager.persist(a);
        entityManager.flush();

    }
    @Override
    public void update(Pelanggan pel) {
        Pelanggan p = get(pel.getId());
        p.setNama(pel.getNama());
        p.setJenis(pel.getJenis());//merubah nama saja
        p.setAlamat(pel.getAlamat()); //merubah alamat saja
        entityManager.flush();

    }
    @Override
    public Pelanggan get(int id) {
        return entityManager.find(Pelanggan.class, id);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(get(id));
    }

    @Override
    public List<Transaksi> getByName(String nama) {
        return entityManager.createQuery("from Pelanggan where nama =:namaPelanggan")
                .setParameter("namaPelanggan",nama)
                .getResultList();
    }

    @Override
    public Object getByNamePassword(String nama, String password) {
        return entityManager.createQuery("from Pelanggan where nama =: namaPelanggan and password=: pass")
                .setParameter("namaPelanggan",nama)
                .setParameter("pass",password).getSingleResult();

//        Query query = entityManager.createNativeQuery()
    }
}

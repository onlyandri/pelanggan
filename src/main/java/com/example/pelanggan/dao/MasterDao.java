package com.example.pelanggan.dao;

import com.example.pelanggan.model.Mastertype;
import com.example.pelanggan.repo.MasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class MasterDao implements MasterRepo {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Mastertype> getAll() {
        return entityManager.createQuery("from Mastertype ").getResultList();
    }

    @Override
    public void tambah(Mastertype a) {

    }

    @Override
    public void update(Mastertype a) {

    }

    @Override
    public Mastertype get(int id) {
        return null;
    }

    @Override
    public void delete(Mastertype a) {

    }

    @Override
    public List<Mastertype> getByName(String nama) {
        return null;
    }
}

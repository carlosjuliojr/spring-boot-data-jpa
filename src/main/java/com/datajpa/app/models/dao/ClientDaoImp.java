package com.datajpa.app.models.dao;

import com.datajpa.app.models.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository("ClientDaoJPA")
public class ClientDaoImp implements IClientDao{
@PersistenceContext
private EntityManager em;
    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return em.createQuery("from Client").getResultList();
    }

    @Override
    @Transactional
    public void save(Client client) {
        em.persist(client);
    }
}

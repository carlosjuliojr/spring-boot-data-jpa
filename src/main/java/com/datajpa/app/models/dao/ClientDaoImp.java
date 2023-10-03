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

    public List<Client> findAll() {
        return em.createQuery("from Client").getResultList();
    }

    @Override
    public void save(Client client) {
        //for update
        if(client.getId() != null && client.getId() > 0){
            em.merge(client);
        }else {// for create new client
            em.persist(client);
        }

    }

    @Override
    public Client findOne(Long id) {
        return em.find(Client.class, id);
    }

    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}

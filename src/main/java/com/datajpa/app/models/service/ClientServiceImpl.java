package com.datajpa.app.models.service;

import com.datajpa.app.models.dao.IClientDao;
import com.datajpa.app.models.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClientServiceImpl implements IClientService{
    @Autowired
    private IClientDao clientDao;

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return (List<Client>) clientDao.findAll();
    }

    @Override
    @Transactional
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findOne(Long id) {
        return clientDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientDao.deleteById(id);
    }
}

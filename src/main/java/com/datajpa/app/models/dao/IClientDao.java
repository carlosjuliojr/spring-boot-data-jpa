package com.datajpa.app.models.dao;

import com.datajpa.app.models.entity.Client;

import java.util.List;

public interface IClientDao {

    public List<Client> findAll();

    public void save(Client client);
}

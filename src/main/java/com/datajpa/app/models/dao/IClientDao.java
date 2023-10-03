package com.datajpa.app.models.dao;

import com.datajpa.app.models.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IClientDao  extends CrudRepository<Client, Long> {

}

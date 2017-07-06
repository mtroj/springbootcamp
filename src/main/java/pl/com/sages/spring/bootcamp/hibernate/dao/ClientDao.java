package pl.com.sages.spring.bootcamp.hibernate.dao;

import pl.com.sages.spring.bootcamp.hibernate.model.Client;

import java.util.List;

public interface ClientDao {

    void save(Client client);

    void update(Client client);

    List<Client> findAll(Client client);
}

package pl.com.sages.spring.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.sages.spring.bootcamp.hibernate.dao.ClientDao;
import pl.com.sages.spring.bootcamp.hibernate.model.Client;

@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public void save(Client client){
        clientDao.save(client);
    }

}

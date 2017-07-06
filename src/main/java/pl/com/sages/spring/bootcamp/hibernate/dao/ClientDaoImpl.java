package pl.com.sages.spring.bootcamp.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.com.sages.spring.bootcamp.hibernate.model.Client;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Client client) {
        getCurrentSession().persist(client);
    }

    @Override
    public void update(Client client) {
        getCurrentSession().update(client);
    }

    @Override
    public List<Client> findAll(Client client) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();

        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        criteriaQuery.from(Client.class);

        return getCurrentSession().createQuery(criteriaQuery).list();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}

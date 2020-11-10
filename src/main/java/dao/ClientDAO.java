package dao;

import classes.Car;
import classes.Client;
import interfaces.DAO;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import utils.HibernateSessionFactoryUtil;

import java.util.List;


public class ClientDAO implements DAO<Client> {

    public List<Client> currentObjects;

    public ClientDAO() {
        this.currentObjects = findAll();
    }

    public List<Client> getCurrentObjects() {
        return currentObjects;
    }

    public void setCurrentObjects(List<Client> currentObjects) {
        this.currentObjects = currentObjects;
    }

    public void updateCurrentObjects() {
        currentObjects = findAll();
    }

    @Override
    public void save(Client obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Client obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Client obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Client> search(String fieldName, String value) throws InterruptedException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        fullTextSession.createIndexer().startAndWait();

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Client.class).get();

        org.apache.lucene.search.Query query = queryBuilder.keyword().onField(fieldName).matching(value).createQuery();
        org.hibernate.query.Query hibQuery = fullTextSession.createFullTextQuery(query, Client.class);

        List result = hibQuery.list();

        transaction.commit();
        session.close();

        return result;
    }

    @Override
    public Client getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Client.class, id);
    }

    @Override
    public List<Client> findAll() {
        List<Client> objects = (List<Client>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Client").list();
        return objects;
    }
}

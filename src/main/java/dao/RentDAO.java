package dao;

import classes.Rent;
import interfaces.DAO;
import org.hibernate.*;
import org.hibernate.search.*;
import org.hibernate.search.query.dsl.QueryBuilder;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class RentDAO implements DAO<Rent> {

    public List<Rent> currentObjects;

    public RentDAO() {
        this.currentObjects = findAll();
    }

    public List<Rent> getCurrentObjects() {
        return currentObjects;
    }

    public void setCurrentObjects(List<Rent> currentObjects) {
        this.currentObjects = currentObjects;
    }

    public void updateCurrentObjects() {
        currentObjects = findAll();
    }

    @Override
    public void save(Rent obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Rent obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Rent obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public Rent getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Rent.class, id);
    }

    @Override
    public List<Rent> search(String fieldName, String value) throws InterruptedException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        fullTextSession.createIndexer().startAndWait();

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Rent.class).get();

        org.apache.lucene.search.Query query = queryBuilder.keyword().onField(fieldName).matching(value).createQuery();
        org.hibernate.query.Query hibQuery = fullTextSession.createFullTextQuery(query, Rent.class);

        List result = hibQuery.list();

        transaction.commit();
        session.close();

        return result;
    }

    @Override
    public List<Rent> findAll() {
        List<Rent> objects = (List<Rent>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Rent").list();
        return objects;
    }
}

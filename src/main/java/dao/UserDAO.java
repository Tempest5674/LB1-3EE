package dao;

import classes.User;
import interfaces.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDAO implements DAO<User> {
    @Override
    public void save(User obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(User obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public User getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public List<User> search(String fieldName, String value) throws InterruptedException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        fullTextSession.createIndexer().startAndWait();

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(User.class).get();

        org.apache.lucene.search.Query query = queryBuilder.keyword().onField(fieldName).matching(value).createQuery();
        org.hibernate.query.Query hibQuery = fullTextSession.createFullTextQuery(query, User.class);

        List result = hibQuery.list();

        transaction.commit();
        session.close();

        return result;
    }

    @Override
    public List<User> findAll() {
        List<User> objects = (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User ").list();
        return objects;
    }
}

package interfaces;

import java.util.List;

public interface DAO<T> {

    public void save(T obj);

    public void update(T obj);

    public void delete(T obj);

    public T getById(int id);

    public List<T> search(String fieldName,String value) throws InterruptedException;

    public List<T> findAll();
}

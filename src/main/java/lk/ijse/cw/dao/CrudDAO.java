package lk.ijse.cw.dao;
import java.util.List;



public interface CrudDAO<T> extends SuperDAO{

    public boolean save (T entity);

    public boolean update (T entity);

    boolean delete (String id);

    List<T> getAll ();

    T search (String id);

    String genarateNextID();
}

package lk.ijse.cw.dao;
import lk.ijse.cw.entity.Student;

import java.util.List;



public interface CrudDAO<T> extends SuperDAO{

    public boolean save (T entity);

    public boolean update (T entity);

    boolean delete (String id);

    List<Student> getAll ();

    T search (String id);

    String genarateNextID();
}

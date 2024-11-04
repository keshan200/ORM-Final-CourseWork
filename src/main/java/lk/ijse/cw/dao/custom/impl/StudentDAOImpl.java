package lk.ijse.cw.dao.custom.impl;

import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.config.FactoryConfiguration;
import lk.ijse.cw.dao.custom.StudentDAO;
import lk.ijse.cw.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {


    @Override
    public boolean save(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Object save = session.save(entity);

        if (save != null) {
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }



    @Override
    public boolean update(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }



    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Student where NIC = ?1");
        query.setParameter(1, id);

        boolean Delete = query.executeUpdate() > 0;

        if (Delete) {
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }



    @Override
    public List<Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> students = session.createQuery("from Student").list();
        transaction.commit();
        session.close();
        return students;
    }




    @Override
    public Student search(String id) {
        return null;

    }



    @Override
    public String genarateNextID() {
        return "";
    }
}

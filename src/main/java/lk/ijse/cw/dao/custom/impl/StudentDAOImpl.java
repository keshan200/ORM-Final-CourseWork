package lk.ijse.cw.dao.custom.impl;

import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.config.FactoryConfiguration;
import lk.ijse.cw.dao.custom.StudentDAO;
import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Student;
import lk.ijse.cw.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
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


    @Override
    public List<Student> searchNameFromNIC(String nic) {
        Session session = FactoryConfiguration.getInstance().getSession();
        List<Student> stList = new ArrayList<>();

        try {

            Query<Object[]> query = session.createNativeQuery("SELECT name, user_uID FROM student WHERE NIC = :nic");
            query.setParameter("nic", nic);

            List<Object[]> results = query.list();

            for (Object[] result : results) {
                String name = (String) result[0];
                String user_uID = (String) result[1];


                User user = session.get(User.class, user_uID);

                Student student = new Student();
                student.setName(name);
                student.setUser(user);
                stList.add(student);
            }
        } finally {
            session.close();
        }

        return stList;
    }



}

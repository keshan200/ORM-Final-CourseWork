package lk.ijse.cw.dao.custom.impl;

import lk.ijse.cw.config.FactoryConfiguration;
import lk.ijse.cw.dao.custom.RegisterDAO;
import lk.ijse.cw.entity.Register;
import lk.ijse.cw.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public boolean save(Register entity) {
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
    public boolean update(Register entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Student> getAll() {
        return List.of();
    }

    @Override
    public Register search(String id) {
        return null;
    }

    @Override
    public String genarateNextID() {
        return "";
    }
}

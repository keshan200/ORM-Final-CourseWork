package lk.ijse.cw.dao.custom.impl;

import lk.ijse.cw.config.FactoryConfiguration;
import lk.ijse.cw.dao.custom.RegisterDAO;
import lk.ijse.cw.entity.Register;
import lk.ijse.cw.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Register> getAll() {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Register> reg = session.createQuery("from Register ").list();
        transaction.commit();
        session.close();
        return reg;
    }

    @Override
    public Register search(String id) {
        return null;
    }

    @Override
    public String genarateNextID() {
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            Query<String> query = session.createQuery("SELECT Rid FROM Register ORDER BY Rid DESC LIMIT 1", String.class);
            query.setMaxResults(1);

            String lastId = query.uniqueResult();

            if (lastId != null && lastId.startsWith("R")) {
                int idNum = Integer.parseInt(lastId.substring(1)) + 1;
                return String.format("R%03d", idNum);
            } else {
                return "R001";
            }
        } finally {
            session.close();
        }
    }
}

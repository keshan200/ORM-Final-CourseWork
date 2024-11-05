package lk.ijse.cw.dao.custom.impl;

import lk.ijse.cw.config.FactoryConfiguration;
import lk.ijse.cw.dao.custom.ProgramDAO;
import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {
    @Override
    public boolean save(Program entity) {

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
    public boolean update(Program entity) {
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

        Query query = session.createQuery("delete from Program where cId = ?1");
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
    public List<Program> getAll() {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Program> program = session.createQuery("from Program ").list();
        transaction.commit();
        session.close();
        return program;
    }

    @Override
    public Program search(String id) {
        return null;
    }

    @Override
    public String genarateNextID() {
        return "";
    }
}

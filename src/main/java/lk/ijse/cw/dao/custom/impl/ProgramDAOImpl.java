package lk.ijse.cw.dao.custom.impl;

import lk.ijse.cw.config.FactoryConfiguration;
import lk.ijse.cw.dao.custom.ProgramDAO;
import lk.ijse.cw.entity.Program;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Program> getAll() {
        return List.of();
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

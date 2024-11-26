package lk.ijse.cw.dao.custom.impl;
import lk.ijse.cw.config.FactoryConfiguration;
import lk.ijse.cw.dao.custom.UserDAO;
import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Register;
import lk.ijse.cw.entity.Student;
import lk.ijse.cw.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;



public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(User entity) {
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
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<User> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        transaction.commit();
        session.close();
        return users;
    }

    @Override
    public User search(String id) {
        return null;
    }

    @Override
    public String genarateNextID() {
        return "";
    }
}

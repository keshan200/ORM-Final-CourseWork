package lk.ijse.cw.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.cw.config.FactoryConfiguration;
import lk.ijse.cw.dao.custom.LoginDAO;
import lk.ijse.cw.entity.Login;
import lk.ijse.cw.entity.User;
import lk.ijse.cw.entity.UserSession;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {

    @Override
    public boolean checkCredential(Login login) throws SQLException, IOException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Query<User> query = session.createQuery("FROM User u WHERE u.name = :username", User.class);
            query.setParameter("username", login.getUserName());

            User user = query.uniqueResult();

            if (user != null) {
                if (BCrypt.checkpw(login.getPassword(), user.getPassword())) {


                    session = FactoryConfiguration.getInstance().getSession();
                    UserSession.getInstance().setUser(Integer.parseInt(user.getUID()), user.getRole());
                    return true;
                } else {
                    new Alert(Alert.AlertType.ERROR, "Sorry! Password is incorrect!").show();
                    return false;
                }
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Sorry! User ID can't be found!").show();
                return false;
            }
        } finally {
            session.close();
        }
    }

}

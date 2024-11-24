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

public class LoginDAOImpl implements LoginDAO {
    @Override
    public boolean checkCredentials(Login login) {
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            Query<User> query = session.createQuery("from User where name = :username", User.class);
            query.setParameter("username",login.getUserName());

            User user = query.uniqueResult();

            if(user !=null) {
                if (BCrypt.checkpw(login.getPassword(), user.getPassword())) {

                  session  =  FactoryConfiguration.getInstance().getSession();
                    UserSession.getInstance().setUser(Integer.parseInt(user.getUID()),user.getRole());
                    return true;

                }else {
                    new Alert(Alert.AlertType.ERROR, "Invalid Password").show();
                    return false;
                }

            }else {
                new Alert(Alert.AlertType.ERROR, "Invalid UserID").show();
                return false;
            }

        }finally {
            session.close();
        }
    }
}

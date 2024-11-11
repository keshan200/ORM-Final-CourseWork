package lk.ijse.cw.dao.custom;

import javafx.scene.control.Alert;
import lk.ijse.cw.dao.SuperDAO;
import lk.ijse.cw.entity.Login;
import lk.ijse.cw.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;

public interface LoginDAO extends SuperDAO {

    boolean checkCredential(Login login) throws SQLException, IOException, ClassNotFoundException;

}

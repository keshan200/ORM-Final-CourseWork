package lk.ijse.cw.dao.custom;

import lk.ijse.cw.dao.SuperDAO;
import lk.ijse.cw.entity.Login;

public interface LoginDAO extends SuperDAO {

    boolean checkCredentials(Login login);

}

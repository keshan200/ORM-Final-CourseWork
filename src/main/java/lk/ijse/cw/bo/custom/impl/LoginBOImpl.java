package lk.ijse.cw.bo.custom.impl;

import lk.ijse.cw.DTO.LoginDTO;
import lk.ijse.cw.bo.custom.LoginBO;
import lk.ijse.cw.dao.DAOFactory;
import lk.ijse.cw.dao.custom.LoginDAO;
import lk.ijse.cw.entity.Login;

import java.io.IOException;
import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {


    LoginDAO loginDAO = (LoginDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Login);

    public boolean checkCredential(LoginDTO login) throws SQLException, IOException, ClassNotFoundException {
        return loginDAO.checkCredential(new Login(login.getUserName(), login.getPassword()));
    }
}

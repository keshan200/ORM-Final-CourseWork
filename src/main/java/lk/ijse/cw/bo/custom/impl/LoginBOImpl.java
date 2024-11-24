package lk.ijse.cw.bo.custom.impl;

import lk.ijse.cw.DTO.LoginDTO;
import lk.ijse.cw.bo.custom.LoginBO;
import lk.ijse.cw.dao.DAOFactory;
import lk.ijse.cw.dao.custom.LoginDAO;
import lk.ijse.cw.entity.Login;

public class LoginBOImpl implements LoginBO {

    LoginDAO loginDAO = (LoginDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Login);


    @Override
    public boolean login(LoginDTO loginDTO) {
        return loginDAO.checkCredentials(new Login(loginDTO.getUserName(),loginDTO.getPassword()));
    }
}

package lk.ijse.cw.dao;

import lk.ijse.cw.dao.custom.UserDAO;
import lk.ijse.cw.dao.custom.impl.*;
import lk.ijse.cw.entity.User;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOFactory() {}


    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType {
        User,Student,Register,Course,Login
    }


    public SuperDAO getDAO(DAOType type) {
        switch (type) {
            case User:
                return new UserDAOImpl();
            case Student:
                return new StudentDAOImpl();
            case Course:
                return new ProgramDAOImpl();
            case Register:
                return new RegisterDAOImpl();
            case Login:
                return new LoginDAOImpl();




                default:
                    return null;

        }
    }

}

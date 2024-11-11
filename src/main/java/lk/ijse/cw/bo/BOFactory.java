package lk.ijse.cw.bo;

import lk.ijse.cw.bo.custom.impl.*;

import lk.ijse.cw.dao.custom.impl.UserDAOImpl;

import static lk.ijse.cw.dao.DAOFactory.DAOType.User;

public class BOFactory {



    private static BOFactory boFactory;

    private BOFactory() {

    }



    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        User,Student,Course,Register,Login
    }


    public SuperBO getBO(BOTypes botype) {
        switch (botype) {
            case User:
                return new UserBOImpl();
            case Student:
                return new StudentBOImpl();
            case Course:
                return new ProgramBOImpl();
            case Register:
                return new RegisterBOImpl();
            case Login:
                return new LoginBOImpl();



        }
        return null;
    }

}

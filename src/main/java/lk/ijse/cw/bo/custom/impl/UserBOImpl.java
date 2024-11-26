package lk.ijse.cw.bo.custom.impl;

import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.custom.UserBO;
import lk.ijse.cw.dao.DAOFactory;
import lk.ijse.cw.dao.custom.UserDAO;
import lk.ijse.cw.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.User);


    @Override
    public boolean saveUser(UserDTO user) {

        return userDAO.save(new User(user.getUID(),user.getPassword(),user.getEmail(),user.getName(),user.getRole(),null));
    }

    @Override
    public boolean updateUser(UserDTO user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public List<UserDTO> getUsers() {
        ArrayList<UserDTO> user = new ArrayList<>();
        List<User> users = userDAO.getAll();

        for (User u : users) {
            user.add(new UserDTO(u.getUID(),u.getName(),u.getEmail(),u.getRole(),u.getPassword()));
        }
        return user;
    }

    @Override
    public ArrayList<String> loadAllUserIDs() {
        return null;
    }

    @Override
    public UserDTO serachUser(String UserID) {
        return null;
    }
}

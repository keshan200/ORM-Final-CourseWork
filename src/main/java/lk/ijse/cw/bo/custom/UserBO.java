package lk.ijse.cw.bo.custom;

import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.SuperBO;

import java.util.ArrayList;
import java.util.List;

public interface UserBO extends SuperBO {

    boolean saveUser(UserDTO user);
    boolean updateUser(UserDTO user);
    boolean deleteUser(int id);

    List<UserDTO> getUsers();
    ArrayList<String> loadAllUserIDs();
    UserDTO serachUser(String UserID);






}

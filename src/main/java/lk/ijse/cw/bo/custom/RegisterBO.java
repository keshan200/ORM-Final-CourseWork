package lk.ijse.cw.bo.custom;

import lk.ijse.cw.DTO.RegisterDTO;
import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RegisterBO extends SuperBO {


    boolean Register(RegisterDTO Register);
    boolean update(RegisterDTO Register);
    boolean delete(String id);

    List<RegisterDTO> getAll();
    ArrayList<String> loadAllRegisters();
    RegisterDTO serach(String ID);

    String generateNewID() throws SQLException, ClassNotFoundException;
}

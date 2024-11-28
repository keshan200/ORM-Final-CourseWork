package lk.ijse.cw.bo.custom;

import lk.ijse.cw.DTO.RegisterDTO;
import lk.ijse.cw.bo.SuperBO;
import lk.ijse.cw.entity.Register;

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

    List<RegisterDTO> getRegisterationByNIC(String nic) throws SQLException;

    List<RegisterDTO>getPendingPayments() throws SQLException;
}

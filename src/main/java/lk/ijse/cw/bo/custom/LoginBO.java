package lk.ijse.cw.bo.custom;

import lk.ijse.cw.DTO.LoginDTO;
import lk.ijse.cw.bo.SuperBO;

import java.io.IOException;
import java.sql.SQLException;

public interface LoginBO extends SuperBO {


    boolean checkCredential(LoginDTO login) throws SQLException, IOException, ClassNotFoundException;
}

package lk.ijse.cw.bo.custom;

import lk.ijse.cw.DTO.LoginDTO;
import lk.ijse.cw.bo.SuperBO;

public interface LoginBO extends SuperBO {

    boolean login(LoginDTO loginDTO);
}

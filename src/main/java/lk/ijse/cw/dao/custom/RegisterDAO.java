package lk.ijse.cw.dao.custom;

import lk.ijse.cw.dao.CrudDAO;
import lk.ijse.cw.entity.Register;

import java.sql.SQLException;
import java.util.List;

public interface RegisterDAO extends CrudDAO<Register> {


    List<Register> getRegisterationByNIC(String nic) throws SQLException;
}

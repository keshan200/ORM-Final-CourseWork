package lk.ijse.cw.bo.custom.impl;

import lk.ijse.cw.DTO.RegisterDTO;
import lk.ijse.cw.bo.custom.RegisterBO;
import lk.ijse.cw.config.FactoryConfiguration;
import lk.ijse.cw.dao.DAOFactory;
import lk.ijse.cw.dao.custom.ProgramDAO;
import lk.ijse.cw.dao.custom.StudentDAO;
import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RegisterBOImpl implements RegisterBO {


    StudentDAO StudetDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Student);
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Course);



    @Override
    public boolean Register(RegisterDTO Register) {
        return false;
    }

    @Override
    public boolean update(RegisterDTO Register) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<RegisterDTO> getAll() {
        return List.of();
    }

    @Override
    public ArrayList<String> loadAllRegisters() {
        return null;
    }

    @Override
    public RegisterDTO serach(String ID) {
        return null;
    }
}

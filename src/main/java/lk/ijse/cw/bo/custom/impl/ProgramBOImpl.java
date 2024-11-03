package lk.ijse.cw.bo.custom.impl;

import lk.ijse.cw.DTO.ProgramDTO;
import lk.ijse.cw.bo.custom.ProgramBO;
import lk.ijse.cw.dao.DAOFactory;
import lk.ijse.cw.dao.custom.ProgramDAO;
import lk.ijse.cw.dao.custom.impl.ProgramDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {


    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Course);


    @Override
    public boolean saveProgram(ProgramDTO program) {
        return false;
    }

    @Override
    public boolean updateProgram(ProgramDTO program) {
        return false;
    }

    @Override
    public boolean deleteProgram(String id) {
        return false;
    }

    @Override
    public List<ProgramDTO> getProgram() {
        return List.of();
    }

    @Override
    public ArrayList<String> loadAllProgramrIDs() {
        return null;
    }

    @Override
    public ProgramDTO serachProgramr(String ProgramID) {
        return null;
    }
}

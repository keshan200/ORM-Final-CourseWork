package lk.ijse.cw.bo.custom.impl;

import lk.ijse.cw.DTO.ProgramDTO;
import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.custom.ProgramBO;
import lk.ijse.cw.dao.DAOFactory;
import lk.ijse.cw.dao.custom.ProgramDAO;
import lk.ijse.cw.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {


    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Course);


    @Override
    public boolean saveProgram(ProgramDTO program) {
       return programDAO.save(new Program(program.getCId(),program.getCName(),program.getDuration(),program.getFee(),null));
    }

    @Override
    public boolean updateProgram(ProgramDTO program) {
        return programDAO.update(new Program(program.getCId(),program.getCName(),program.getDuration(),program.getFee(),null));
    }

    @Override
    public boolean deleteProgram(String id) {
        return programDAO.delete(id);
    }

    @Override
    public List<ProgramDTO> getProgram() {
        ArrayList<ProgramDTO> program = new ArrayList<>();

        List<Program> entityList = programDAO.getAll();

        for (Program p : entityList) {

            program.add(new ProgramDTO(p.getCId(), p.getCName(), p.getDuration(), p.getFee()));
        }

        return program;
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

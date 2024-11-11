package lk.ijse.cw.dao.custom;

import lk.ijse.cw.dao.CrudDAO;
import lk.ijse.cw.entity.Program;

import java.util.List;

public interface ProgramDAO extends CrudDAO<Program> {


List<String>getProgramName();

List<Program> SearchByProgramName(String programName);


}

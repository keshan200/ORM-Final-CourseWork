package lk.ijse.cw.bo.custom;

import lk.ijse.cw.DTO.ProgramDTO;
import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.SuperBO;

import java.util.ArrayList;
import java.util.List;

public interface ProgramBO extends SuperBO {


    boolean saveProgram(ProgramDTO program);
    boolean updateProgram(ProgramDTO program);
    boolean deleteProgram(String id);

    List<ProgramDTO> getProgram();
    ArrayList<String> loadAllProgramrIDs();
    ProgramDTO serachProgramr(String ProgramID);
}

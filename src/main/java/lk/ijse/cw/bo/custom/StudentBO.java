package lk.ijse.cw.bo.custom;

import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.SuperBO;

import java.util.ArrayList;
import java.util.List;

public interface StudentBO extends SuperBO {


    boolean saveStu(StudentDTO student);
    boolean updateStu(StudentDTO student);
    boolean deleteStu(String id);

    List<StudentDTO> getStudents();
    ArrayList<String> loadAllStudentIDs();
    UserDTO serachUser(String stID);
}

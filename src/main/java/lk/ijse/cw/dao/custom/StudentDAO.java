package lk.ijse.cw.dao.custom;

import lk.ijse.cw.dao.CrudDAO;
import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student>{


    List<Student> searchNameFromNIC(String nic);


}

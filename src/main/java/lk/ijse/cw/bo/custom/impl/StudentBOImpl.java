package lk.ijse.cw.bo.custom.impl;

import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.custom.StudentBO;
import lk.ijse.cw.dao.DAOFactory;
import lk.ijse.cw.dao.custom.StudentDAO;
import lk.ijse.cw.dao.custom.UserDAO;
import lk.ijse.cw.entity.Student;
import lk.ijse.cw.entity.User;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {


    StudentDAO StudetDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Student);
    UserDAO uDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.User);




    @Override
    public boolean saveStu(StudentDTO student) {

        UserDTO user = student.getUser();
        User user1 = new User(user.getUID(),user.getPassword(),user.getEmail(),user.getName(),user.getRole(),null);

        return StudetDAO.save(new Student(student.getNIC(),user1,student.getName(),student.getEmail(),student.getAddress(),student.getBday(),student.getTel(),student.getGender(),null));
    }

    @Override
    public boolean updateStu(StudentDTO student) {
        return false;
    }

    @Override
    public boolean deleteStu(String id) {
        return false;
    }

    @Override
    public List<UserDTO> getStudents() {
        return List.of();
    }

    @Override
    public ArrayList<String> loadAllStudentIDs() {
        return null;
    }

    @Override
    public UserDTO serachUser(String stID) {
        User user = uDAO.search(stID) ;
        if (user != null) {
            return new UserDTO(user.getUID(), user.getPassword(), user.getEmail(), user.getName(), user.getRole());
        }
        return null;
    }
}

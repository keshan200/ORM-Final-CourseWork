package lk.ijse.cw.bo.custom.impl;

import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.bo.custom.StudentBO;
import lk.ijse.cw.dao.DAOFactory;
import lk.ijse.cw.dao.custom.StudentDAO;
import lk.ijse.cw.dao.custom.UserDAO;
import lk.ijse.cw.entity.Student;
import lk.ijse.cw.entity.User;

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

        UserDTO user = student.getUser();
        User user1 = new User(user.getUID(),user.getPassword(),user.getEmail(),user.getName(),user.getRole(),null);
        return StudetDAO.save(new Student(student.getNIC(),user1,student.getName(),student.getEmail(),student.getAddress(),student.getBday(),student.getTel(),student.getGender(),null));
    }

    @Override
    public boolean deleteStu(String id) {
        return StudetDAO.delete(id);
    }

    @Override
    public List<StudentDTO> getStudents() {

        ArrayList<StudentDTO> students = new ArrayList<>();

        List<Student> entityList = StudetDAO.getAll();

        for (Student s : entityList) {
            UserDTO userDTO = new UserDTO(
                    s.getUser().getUID(),
                    s.getUser().getPassword(),
                    s.getUser().getEmail(),
                    s.getUser().getName(),
                    s.getUser().getRole()
            );

            students.add(new StudentDTO(
                    s.getNIC(),
                    userDTO,
                    s.getName(),
                    s.getEmail(),
                    s.getAddress(),
                    s.getBday(),
                    s.getTel(),
                    s.getGender()
            ));
        }

        return students;
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

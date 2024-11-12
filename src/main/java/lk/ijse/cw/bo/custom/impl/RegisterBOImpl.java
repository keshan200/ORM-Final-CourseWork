package lk.ijse.cw.bo.custom.impl;

import lk.ijse.cw.DTO.ProgramDTO;
import lk.ijse.cw.DTO.RegisterDTO;
import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.bo.custom.RegisterBO;
import lk.ijse.cw.config.FactoryConfiguration;
import lk.ijse.cw.dao.DAOFactory;
import lk.ijse.cw.dao.custom.ProgramDAO;
import lk.ijse.cw.dao.custom.RegisterDAO;
import lk.ijse.cw.dao.custom.StudentDAO;
import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Register;
import lk.ijse.cw.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterBOImpl implements RegisterBO {


   RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Register);



    @Override
    public boolean Register(RegisterDTO reg) {
        Student student = new Student(reg.getStudent().getNIC());
        Program program = new Program(reg.getProgram().getCId());
        return registerDAO.save(new Register(reg.getRid(),student,program,reg.getDate(),reg.getRegisterFee(),reg.getBalance(),reg.getPaymentStatus()));
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
        ArrayList<RegisterDTO> reg = new ArrayList<>();

        List<Register> entityList = registerDAO.getAll();

        for (Register p : entityList) {

            StudentDTO studentDTO = new StudentDTO(
                    p.getStudent().getNIC()

            );
            ProgramDTO programDTO = new ProgramDTO(
                    p.getProgram().getCId()
            );

            reg.add(new RegisterDTO(p.getRid(),studentDTO,programDTO,p.getDate(),p.getRegisterFee(),p.getBalance(),p.getPaymentStatus()));
        }

        return reg;
    }

    @Override
    public ArrayList<String> loadAllRegisters() {
        return null;
    }

    @Override
    public RegisterDTO serach(String ID) {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return registerDAO.genarateNextID();
    }
}

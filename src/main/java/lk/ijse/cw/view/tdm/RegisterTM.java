package lk.ijse.cw.view.tdm;

import lk.ijse.cw.DTO.ProgramDTO;
import lk.ijse.cw.DTO.StudentDTO;
import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterTM {


    private String Rid;
    private StudentDTO student;
    private ProgramDTO program;
    private LocalDate date;
    private Double RegisterFee;
    private Double balance;
    private String PaymentStatus;



}

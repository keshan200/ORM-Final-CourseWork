package lk.ijse.cw.DTO;


import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterDTO {

    private String Rid;
    private StudentDTO student;
    private ProgramDTO program;
    private LocalDate date;
    private Double RegisterFee;
    private Double balance;
    private String PaymentStatus;



}

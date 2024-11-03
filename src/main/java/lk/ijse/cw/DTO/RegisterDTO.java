package lk.ijse.cw.DTO;


import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Student;

import java.time.LocalDate;

public class RegisterDTO {

    private int Rid;

    private Student student;
    private Program program;

    private LocalDate date;
    private Double RegisterFee;
    private String PaymentStatus;
}

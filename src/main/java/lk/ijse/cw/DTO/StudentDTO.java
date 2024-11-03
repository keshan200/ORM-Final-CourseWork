package lk.ijse.cw.DTO;

import lk.ijse.cw.entity.User;
import lombok.*;

import java.time.LocalDate;





@NoArgsConstructor
@AllArgsConstructor
@Data

public class StudentDTO {


    private String NIC;
    private UserDTO user;
    private String name;
    private String email;
    private String address;
    private LocalDate bday;
    private int tel;
    private String gender;



}

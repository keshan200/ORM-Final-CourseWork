package lk.ijse.cw.view.tdm;

import lk.ijse.cw.DTO.UserDTO;
import lk.ijse.cw.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class StudentTM {

    private String NIC;
    private UserDTO user;
    private String name;
    private String email;
    private String address;
    private LocalDate bday;
    private int tel;
    private String gender;



}

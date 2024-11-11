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


    public StudentDTO(String nic, String adr, int tel, String bday) {
        this.NIC = nic;
        this.address = adr;
        this.tel = tel;
        this.bday = LocalDate.parse(bday);
    }

    public StudentDTO(String name, User user) {
        this.name = name;
        this.user = new UserDTO(user.getUID());
    }

    public StudentDTO(String nic) {
        this.NIC = nic;
    }
}

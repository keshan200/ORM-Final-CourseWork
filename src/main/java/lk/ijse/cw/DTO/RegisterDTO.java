package lk.ijse.cw.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterDTO {


    String id;
    StudentDTO NIC;
    ProgramDTO cID;
    LocalDate date;
    Double RegisterFee;
    String PaymentStatus;
}

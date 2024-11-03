package lk.ijse.cw.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Register {

    @Id
    String id;

    @ManyToOne
    Student NIC;

    @ManyToOne
    Program cID;

    LocalDate date;
    Double RegisterFee;
    String PaymentStatus;
}

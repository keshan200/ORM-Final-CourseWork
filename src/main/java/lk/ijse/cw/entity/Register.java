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
    private int Rid;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Program program;

    private LocalDate date;
    private Double RegisterFee;
    private String PaymentStatus;



}

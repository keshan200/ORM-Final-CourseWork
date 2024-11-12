package lk.ijse.cw.entity;


import jakarta.persistence.*;
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
    private String Rid;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Student student;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Program program;

    private LocalDate date;
    private Double RegisterFee;
    private Double balance;
    private String PaymentStatus;



}

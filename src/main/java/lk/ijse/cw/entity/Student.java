package lk.ijse.cw.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Student {

 @Id
 private String NIC;

 @ManyToOne
 private User user;

 private String name;
 private String email;
 private String address;
 private LocalDate bday;
 private int tel;
 private String gender;

@OneToMany(mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = true)
 List<Register>registers;



 public Student(String nic, String email, String address, int tel) {
  this.NIC = nic;
  this.email = email;
  this.address = address;
  this.tel = tel;
 }

    public Student(String nic) {
     this.NIC = nic;
    }
}

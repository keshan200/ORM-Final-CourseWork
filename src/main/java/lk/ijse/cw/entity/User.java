package lk.ijse.cw.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    private String uID;
    private String password;
    private String email;
    private String name;
    private String role;



    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
     private List<Student> students;



}

package lk.ijse.cw.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Program {

    @Id
    private String cId;
    private String cName;
    private String Duration;
    private Double fee;



}

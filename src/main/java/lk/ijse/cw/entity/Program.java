package lk.ijse.cw.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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


    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Register> registers;

    public Program(String cId) {
        this.cId = cId;
    }
}

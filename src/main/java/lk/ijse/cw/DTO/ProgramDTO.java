package lk.ijse.cw.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProgramDTO {

    private String cId;
    private String cName;
    private String Duration;
    private Double fee;

}

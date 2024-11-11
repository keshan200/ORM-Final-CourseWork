package lk.ijse.cw.DTO;
import lk.ijse.cw.entity.User;
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


    public ProgramDTO(String cId, String duration, Double fee) {
        this.cId = cId;
        this.Duration = duration;
        this.fee = fee;
    }


    public ProgramDTO(String pId) {
        this.cId = pId;
    }
}

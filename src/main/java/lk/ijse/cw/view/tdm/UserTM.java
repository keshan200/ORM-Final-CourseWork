package lk.ijse.cw.view.tdm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserTM {

    private String uID;
    private String password;
    private String email;
    private String name;
    private String role;
}

package lk.ijse.cw.DTO;

import lk.ijse.cw.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDTO {

        private String uID;
        private String password;
        private String email;
        private String name;
        private String role;


        public UserDTO(String uId) {
                this.uID = uId;
        }

}

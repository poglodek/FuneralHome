package p.poglodek.Funeral.Home.Management.Dto.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int phoneNumber;
}

package p.poglodek.Funeral.Home.Management.Dto.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class userRegisterDto {

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public int phoneNumber;
}

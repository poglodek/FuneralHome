package p.poglodek.Funeral.Home.Management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class registerRequest {

    public String firstName;
    public String lastName;
    public String email;
    public String password;
}

package p.poglodek.Funeral.Home.Management.Mappers;

import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.Entity.User;
import p.poglodek.Funeral.Home.Management.Dto.User.UserRegisterDto;

@Service
public class UserMapper {

    public User mapToUser(UserRegisterDto userRegisterDto){
        return new User(
                userRegisterDto.getFirstName(),
                userRegisterDto.getLastName(),
                userRegisterDto.getEmail(),
                userRegisterDto.getPassword(),
                userRegisterDto.getPhoneNumber()
        );

    }
}

package p.poglodek.Funeral.Home.Management.mappers;

import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.entity.User;
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

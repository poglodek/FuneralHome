package p.poglodek.Funeral.Home.Management.mappers;

import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Database.entity.user;
import p.poglodek.Funeral.Home.Management.Dto.User.userRegisterDto;

@Service
public class userMapper {

    public user mapToUser(userRegisterDto userRegisterDto){
        return new user(
                userRegisterDto.getFirstName(),
                userRegisterDto.getLastName(),
                userRegisterDto.getEmail(),
                userRegisterDto.getPassword(),
                userRegisterDto.getPhoneNumber()
        );

    }
}

package p.poglodek.Funeral.Home.Management.mappers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;
import p.poglodek.Funeral.Home.Management.Database.entity.user;
import p.poglodek.Funeral.Home.Management.model.registerRequest;

@Service
public class userMapper {

    public user mapToUser(registerRequest registerRequest){
        return new user(
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                registerRequest.getPhoneNumber()
        );

    }
}

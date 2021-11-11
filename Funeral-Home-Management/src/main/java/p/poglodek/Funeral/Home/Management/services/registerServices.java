package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Enum.statusRegister;
import p.poglodek.Funeral.Home.Management.Dto.User.userRegisterDto;

@Service
@AllArgsConstructor
public class registerServices {


    private final userServices userServices;

    public statusRegister register(userRegisterDto userRegisterDto)
    {
        if(userRegisterDto.getPassword().isEmpty())
            return statusRegister.PASSWORD_REQUIRED;
        else if(userRegisterDto.getFirstName().isEmpty())
            return statusRegister.FIRST_NAME_REQUIRED;
        else if(userRegisterDto.getLastName().isEmpty())
            return statusRegister.LAST_NAME_REQUIRED;
        else if(userRegisterDto.getPhoneNumber() <99999999)
            return statusRegister.PHONE_NUMBER_REQUIRED;
        return  userServices.signUpUser(userRegisterDto);
    }
}

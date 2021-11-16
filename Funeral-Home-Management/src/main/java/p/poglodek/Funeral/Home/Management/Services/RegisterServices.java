package p.poglodek.Funeral.Home.Management.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Enum.StatusRegister;
import p.poglodek.Funeral.Home.Management.Dto.User.UserRegisterDto;

@Service
@AllArgsConstructor
public class RegisterServices {


    private final UserServices userServices;

    public StatusRegister register(UserRegisterDto userRegisterDto)
    {
        if(userRegisterDto.getPassword().isEmpty())
            return StatusRegister.PASSWORD_REQUIRED;
        else if(userRegisterDto.getFirstName().isEmpty())
            return StatusRegister.FIRST_NAME_REQUIRED;
        else if(userRegisterDto.getLastName().isEmpty())
            return StatusRegister.LAST_NAME_REQUIRED;
        else if(userRegisterDto.getPhoneNumber() <99999999)
            return StatusRegister.PHONE_NUMBER_REQUIRED;
        return  userServices.signUpUser(userRegisterDto);
    }
}

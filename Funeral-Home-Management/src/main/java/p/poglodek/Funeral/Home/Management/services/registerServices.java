package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.Enum.statusRegister;
import p.poglodek.Funeral.Home.Management.model.registerRequest;
import p.poglodek.Funeral.Home.Management.validator.emailValidator;

@Service
@AllArgsConstructor
public class registerServices {


    private final userServices userServices;

    public statusRegister register(registerRequest registerRequest)
    {
        if(registerRequest.getPassword().isEmpty())
            return statusRegister.PASSWORD_REQUIRED;
        else if(registerRequest.getFirstName().isEmpty())
            return statusRegister.FIRST_NAME_REQUIRED;
        else if(registerRequest.getLastName().isEmpty())
            return statusRegister.LAST_NAME_REQUIRED;
        else if(registerRequest.getPhoneNumber() <99999999)
            return statusRegister.PHONE_NUMBER_REQUIRED;
        return  userServices.signUpUser(registerRequest);
    }
}

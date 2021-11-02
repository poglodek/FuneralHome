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
        return  userServices.signUpUser(registerRequest);
    }
}

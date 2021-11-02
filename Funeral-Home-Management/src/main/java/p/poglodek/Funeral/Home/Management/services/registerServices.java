package p.poglodek.Funeral.Home.Management.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import p.poglodek.Funeral.Home.Management.model.registerRequest;
import p.poglodek.Funeral.Home.Management.validator.emailValidator;

@Service
@AllArgsConstructor
public class registerServices {

    private final emailValidator emailValidator;
    private final userServices userServices;

    public String register(registerRequest registerRequest)
    {
        var validEmail = emailValidator.test(registerRequest.getEmail());
        if(!validEmail) throw new IllegalStateException("Email is not valid");
        userServices.signUpUser(registerRequest);
        return  null;
    }
}

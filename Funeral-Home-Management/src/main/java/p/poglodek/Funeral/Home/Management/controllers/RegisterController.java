package p.poglodek.Funeral.Home.Management.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import p.poglodek.Funeral.Home.Management.model.registerRequest;
import p.poglodek.Funeral.Home.Management.services.registerServices;

@RestController
@RequestMapping(path = "register")
@AllArgsConstructor
public class RegisterController {

    private registerServices registerServices;
    @PostMapping
    public String register(@RequestBody registerRequest request)
    {

        return  registerServices.register(request);
    }
}

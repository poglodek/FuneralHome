package p.poglodek.Funeral.Home.Management.controllers;

import lombok.AllArgsConstructor;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import p.poglodek.Funeral.Home.Management.model.registerRequest;
import p.poglodek.Funeral.Home.Management.services.registerServices;

@Controller
@AllArgsConstructor
public class RegisterController {

    private registerServices registerServices;

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("status","Register Here!");
        return "register";
    }
    @PostMapping("/register")
    public String register(@RequestBody registerRequest request)
    {
        System.out.println("register POST");
        var result = registerServices.register(request);
        return "register";
    }
}

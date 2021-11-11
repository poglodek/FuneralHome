package p.poglodek.Funeral.Home.Management.controllers;

import lombok.AllArgsConstructor;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.poglodek.Funeral.Home.Management.Enum.statusRegister;
import p.poglodek.Funeral.Home.Management.Dto.User.userRegisterDto;
import p.poglodek.Funeral.Home.Management.services.registerServices;

@Controller
@AllArgsConstructor
public class RegisterController {

    private registerServices registerServices;

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("status","Register Here!");
        model.addAttribute("registerRequest",new userRegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute userRegisterDto request, Model model)
    {
        System.out.println("register POST");
        var result = registerServices.register(request);
        if (result == statusRegister.EMAIL_NOT_VALID)
            model.addAttribute("status","Email not valid");
        else if (result == statusRegister.USER_EXIST)
            model.addAttribute("status","Email was taken");
        else if (result == statusRegister.FIRST_NAME_REQUIRED)
            model.addAttribute("status","First name is not valid");
        else if (result == statusRegister.LAST_NAME_REQUIRED)
            model.addAttribute("status","Last name is not valid");
        else if (result == statusRegister.PASSWORD_REQUIRED)
            model.addAttribute("status","Password  is not valid");
        else if (result == statusRegister.PHONE_NUMBER_REQUIRED)
            model.addAttribute("status","Phone number is not valid");
        else if (result == statusRegister.OK)
            return "redirect:/";
        return "register";
    }

    @GetMapping("/registerSuccessfully")
    public String registerSuccessfully()
    {
        return "registerSuccessfully";
    }

}

package p.poglodek.Funeral.Home.Management.controllers;

import lombok.AllArgsConstructor;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.poglodek.Funeral.Home.Management.Enum.StatusRegister;
import p.poglodek.Funeral.Home.Management.Dto.User.UserRegisterDto;
import p.poglodek.Funeral.Home.Management.services.RegisterServices;

@Controller
@AllArgsConstructor
public class RegisterController {

    private RegisterServices registerServices;

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("status","Register Here!");
        model.addAttribute("registerRequest",new UserRegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegisterDto request, Model model)
    {
        System.out.println("register POST");
        var result = registerServices.register(request);
        if (result == StatusRegister.EMAIL_NOT_VALID)
            model.addAttribute("status","Email not valid");
        else if (result == StatusRegister.USER_EXIST)
            model.addAttribute("status","Email was taken");
        else if (result == StatusRegister.FIRST_NAME_REQUIRED)
            model.addAttribute("status","First name is not valid");
        else if (result == StatusRegister.LAST_NAME_REQUIRED)
            model.addAttribute("status","Last name is not valid");
        else if (result == StatusRegister.PASSWORD_REQUIRED)
            model.addAttribute("status","Password  is not valid");
        else if (result == StatusRegister.PHONE_NUMBER_REQUIRED)
            model.addAttribute("status","Phone number is not valid");
        else if (result == StatusRegister.OK)
            return "redirect:/";
        return "register";
    }

    @GetMapping("/registerSuccessfully")
    public String registerSuccessfully()
    {
        return "registerSuccessfully";
    }

}

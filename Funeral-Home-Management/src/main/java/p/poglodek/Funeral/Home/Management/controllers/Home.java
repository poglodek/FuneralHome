package p.poglodek.Funeral.Home.Management.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class Home {

    @GetMapping("/")
    public String index(Model model)
    {
        return "index";
    }
}

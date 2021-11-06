package p.poglodek.Funeral.Home.Management.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import p.poglodek.Funeral.Home.Management.mappers.flowerMapper;
import p.poglodek.Funeral.Home.Management.services.flowerServices;

@Controller
@AllArgsConstructor
public class FlowerController {

    private flowerServices flowerServices;


    @GetMapping("/flowers")
    public String flowersList(Model model){
        model.addAttribute("flowers", flowerServices.GetFlowers());
        return "flowers/flowersList";
    }
}

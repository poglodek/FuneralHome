package p.poglodek.Funeral.Home.Management.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.poglodek.Funeral.Home.Management.Dto.Flower.FlowerDto;
import p.poglodek.Funeral.Home.Management.mappers.flowerMapper;
import p.poglodek.Funeral.Home.Management.model.registerRequest;
import p.poglodek.Funeral.Home.Management.services.flowerServices;

@Controller
@AllArgsConstructor
@RequestMapping("/flower")
public class FlowerController {

    private flowerServices flowerServices;


    @GetMapping("/all")
    public String flowersList(Model model){
        model.addAttribute("flowers", flowerServices.GetFlowers());
        return "flowers/flowersList";
    }
    @GetMapping("/add")
    public String addFlower(Model model){
        model.addAttribute("status", "Add new flower");
        model.addAttribute("flowerDto",new FlowerDto());
        return "flowers/flowerAdd";
    }
    @PostMapping("/add")
    public String addFlower(@ModelAttribute FlowerDto flowerDto, Model model){
        model.addAttribute("status", "Added");
        return "flowers/flowerAdd";
    }
}

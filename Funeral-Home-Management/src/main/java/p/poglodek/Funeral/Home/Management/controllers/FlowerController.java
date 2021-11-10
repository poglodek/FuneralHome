package p.poglodek.Funeral.Home.Management.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.poglodek.Funeral.Home.Management.Dto.Flower.FlowerDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
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

        var result = flowerServices.AddFlower(flowerDto);
        if (result == CrudEnum.INVALID_NAME)
            model.addAttribute("status", "Invalid flower name");
        else if(result == CrudEnum.INVALID_DESCRIPTION)
            model.addAttribute("status", "Invalid flower description");
        else if(result == CrudEnum.INVALID_PRICE)
            model.addAttribute("status", "Invalid flower price");
        else if(result == CrudEnum.CREATED)
            model.addAttribute("status", "Flower Added successfully.");
        return "flowers/flowerAdd";
    }
}

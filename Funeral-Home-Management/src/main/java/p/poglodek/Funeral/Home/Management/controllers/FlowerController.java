package p.poglodek.Funeral.Home.Management.controllers;


import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.poglodek.Funeral.Home.Management.Dto.Flower.FlowerDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.services.flowerServices;

@Controller
@AllArgsConstructor
@RequestMapping("/flower")
public class FlowerController {

    private flowerServices flowerServices;


    @GetMapping("/all")
    public String flowersList(Model model){
        var username = SecurityContextHolder.getContext().getAuthentication().getName();

        model.addAttribute("flowers", flowerServices.GetFlowersOfUser());
        return "flowers/flowersList";
    }
    @GetMapping("/{id}")
    public String infoFlower(@PathVariable("id") String id, Model model)
    {
        var flower = flowerServices.getFlower(id);
        model.addAttribute("flower",flower == null ? "" : flower);

        return "/flowers/infoFlower";
    }

    @GetMapping("/edit/{id}")
    public String editFlower(@PathVariable("id") String id, Model model)
    {
        model.addAttribute("status","Edit Flower");
        model.addAttribute("flowerDto",flowerServices.getFlower(id));
        model.addAttribute("flowerId", id);

        return "/flowers/flowerEdit";
    }
    @PostMapping("/edit/{id}")
    public String editFlower(@PathVariable("id") String id, Model model,@ModelAttribute FlowerDto flowerDto)
    {
        var result = flowerServices.updateFlower(flowerDto, id);
        if (result == CrudEnum.UPDATED)
            return "redirect:/flower/all";
        else if(result == CrudEnum.INVALID_PRICE)
            model.addAttribute("status","Invalid Price");
        else if(result == CrudEnum.INVALID_DESCRIPTION)
            model.addAttribute("status","Invalid Description");
        else if(result == CrudEnum.INVALID_NAME)
            model.addAttribute("status","Invalid Name");
        else
            model.addAttribute("status","You Cannot update this flower");
        model.addAttribute("flowerDto",flowerDto);
        model.addAttribute("flowerId", id);
        return "/flowers/flowerEdit";
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

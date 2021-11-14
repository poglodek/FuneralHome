package p.poglodek.Funeral.Home.Management.controllers;


import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.poglodek.Funeral.Home.Management.Dto.burialType.burialTypeDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.services.burialTypeServices;
import p.poglodek.Funeral.Home.Management.services.flowerServices;

@Controller
@AllArgsConstructor
@RequestMapping("/burialTypes")
public class BurialTypesController {

    private burialTypeServices burialTypeServices;


    @GetMapping("/{id}")
    public String infoFlower(@PathVariable("id") String id, Model model) {
        model.addAttribute("burialType", burialTypeServices.getBurialTypeDtoById(id));
        return "burialTypes/burialTypeInfo";
    }

    @GetMapping("/all")
    public String burialTypesList(Model model){
        model.addAttribute("burialTypes", burialTypeServices.getBurialTypesDtoOfUser());
        return "burialTypes/burialTypesList";
    }
    @GetMapping("/add")
    public String addBurialType(Model model){
        model.addAttribute("status", "Add new burial type");
        model.addAttribute("burialTypeDto", new burialTypeDto());
        return "burialTypes/burialTypeAdd";
    }
    @PostMapping("/add")
    public String addBurialType(Model model, @ModelAttribute burialTypeDto burialTypeDto){
        var result = burialTypeServices.AddNewBurialType(burialTypeDto);
        if (result == CrudEnum.UPDATED)
            return "redirect:/burialTypes/all";
        else if(result == CrudEnum.INVALID_PRICE)
            model.addAttribute("status","Invalid Price");
        else if(result == CrudEnum.INVALID_DESCRIPTION)
            model.addAttribute("status","Invalid Description");
        else if(result == CrudEnum.INVALID_NAME)
            model.addAttribute("status","Invalid Name");
        else
            model.addAttribute("status","You Cannot add burial type");
        model.addAttribute("burialTypeDto", burialTypeDto);
        return "burialTypes/burialTypeAdd";
    }


}

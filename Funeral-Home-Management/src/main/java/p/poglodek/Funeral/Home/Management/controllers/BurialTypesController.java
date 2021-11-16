package p.poglodek.Funeral.Home.Management.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.poglodek.Funeral.Home.Management.Dto.BurialType.BurialTypeDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.services.BurialTypeServices;

@Controller
@AllArgsConstructor
@RequestMapping("/burialTypes")
public class BurialTypesController {

    private BurialTypeServices burialTypeServices;

    @GetMapping("/edit/{id}")
    public String editBurialType(@PathVariable("id") String id, Model model){

        model.addAttribute("status","Edit Burial Type");
        model.addAttribute("burialTypeDto",burialTypeServices.getBurialTypeDtoById(id));
        model.addAttribute("burialTypeId", id);

        return "burialTypes/burialTypeEdit";
    }
    @PostMapping("/edit/{id}")
    public String editBurialType(@PathVariable("id") String id, Model model,@ModelAttribute BurialTypeDto burialTypeDto) {
        var result = burialTypeServices.updateBurialType(burialTypeDto, id);
        if (result == CrudEnum.UPDATED)
            return "redirect:/burialTypes/all";
        else if(result == CrudEnum.INVALID_PRICE)
            model.addAttribute("status","Invalid Price");
        else if(result == CrudEnum.INVALID_DESCRIPTION)
            model.addAttribute("status","Invalid Description");
        else if(result == CrudEnum.INVALID_NAME)
            model.addAttribute("status","Invalid Name");
        else
            model.addAttribute("status","You Cannot update this flower");
        model.addAttribute("burialTypeDto",burialTypeDto);
        model.addAttribute("burialTypeId", id);
        return "burialTypes/burialTypeEdit";
    }
    @GetMapping("/{id}")
    public String infoFlower(@PathVariable("id") String id, Model model) {
        model.addAttribute("burialType", burialTypeServices.getBurialTypeDtoById(id));
        return "burialTypes/burialTypeInfo";
    }

    @GetMapping("")
    public String burialTypesList(Model model)
    {
        model.addAttribute("burialTypes", burialTypeServices.getBurialTypesDtoOfUser());
        return "burialTypes/burialTypesList";
    }
    @GetMapping("/add")
    public String addBurialType(Model model){
        model.addAttribute("status", "Add new burial type");
        model.addAttribute("burialTypeDto", new BurialTypeDto());
        return "burialTypes/burialTypeAdd";
    }
    @PostMapping("/add")
    public String addBurialType(Model model, @ModelAttribute BurialTypeDto burialTypeDto){
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

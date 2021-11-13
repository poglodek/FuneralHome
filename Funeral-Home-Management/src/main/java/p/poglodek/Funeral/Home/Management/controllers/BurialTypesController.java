package p.poglodek.Funeral.Home.Management.controllers;


import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import p.poglodek.Funeral.Home.Management.Dto.burialType.burialTypeDto;
import p.poglodek.Funeral.Home.Management.services.burialTypeServices;

@Controller
@AllArgsConstructor
@RequestMapping("/burialTypes")
public class BurialTypesController {

    private burialTypeServices burialTypeServices;

    @GetMapping("/all")
    public String burialTypesList(Model model){
        model.addAttribute("burialTypes",burialTypeServices.getBurialTypesDtoOfUser());
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
        model.addAttribute("status", "Added ");
        model.addAttribute("burialTypeDto", burialTypeDto);
        return "burialTypes/burialTypeAdd";
    }
}

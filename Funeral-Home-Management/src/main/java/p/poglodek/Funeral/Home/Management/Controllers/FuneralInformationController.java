package p.poglodek.Funeral.Home.Management.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.poglodek.Funeral.Home.Management.Database.Entity.BurialType;
import p.poglodek.Funeral.Home.Management.Dto.FuneralInformation.FuneralInformationCreateDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
import p.poglodek.Funeral.Home.Management.Services.BurialTypeServices;
import p.poglodek.Funeral.Home.Management.Services.ClientServices;
import p.poglodek.Funeral.Home.Management.Services.FlowerServices;
import p.poglodek.Funeral.Home.Management.Services.FuneralInformationServices;

@Controller
@AllArgsConstructor
@RequestMapping("FuneralInformation")
public class FuneralInformationController {

    private FuneralInformationServices funeralInformationServices;
    private ClientServices clientServices;
    private FlowerServices flowerServices;
    private BurialTypeServices burialTypeServices;



    @GetMapping("")
    public String getListFuneralInformation(Model model){
        model.addAttribute("funeralInformational", funeralInformationServices.getFuneralInformationList());
        return "FuneralInformation/FuneralInformationList";
    }

    @GetMapping("/{id}")
    public String getFuneralInformation(@PathVariable("id") String id, Model model){
        var a =  funeralInformationServices.getFuneralInformationDto(id);
        model.addAttribute("funeralInformational",a);
        return "FuneralInformation/FuneralInformationInfo";
    }

    @GetMapping("add")
    public String addFuneralInformation(Model model){
        model.addAttribute("status", "Create new!");
        model.addAttribute("clients", clientServices.getClientsDto());
        model.addAttribute("flowers", flowerServices.GetFlowersOfUser());
        model.addAttribute("burialTypes", burialTypeServices.getBurialTypesDtoOfUser());
        model.addAttribute("FuneralInformationCreateDto", new FuneralInformationCreateDto());
        return "FuneralInformation/FuneralInformationAdd";
    }
    @PostMapping("add")
    public String addFuneralInformation(Model model, @ModelAttribute FuneralInformationCreateDto funeralInformationCreateDto){
        var result = funeralInformationServices.addFuneralInformation(funeralInformationCreateDto);
        if(result == CrudEnum.CREATED)
            return "redirect:/FuneralInformation/";
        else if(result == CrudEnum.INVALID_DATE)
            model.addAttribute("status", "Invalid Date.");
        model.addAttribute("clients", clientServices.getClientsDto());
        model.addAttribute("flowers", flowerServices.GetFlowersOfUser());
        model.addAttribute("burialTypes", burialTypeServices.getBurialTypesDtoOfUser());
        model.addAttribute("FuneralInformationCreateDto", funeralInformationCreateDto);
        return "FuneralInformation/FuneralInformationAdd";
    }
}

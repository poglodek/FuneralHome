package p.poglodek.Funeral.Home.Management.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import p.poglodek.Funeral.Home.Management.Database.Entity.BurialType;
import p.poglodek.Funeral.Home.Management.Dto.FuneralInformation.FuneralInformationCreateDto;
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
    public String getFuneralInformation(Model model){
        model.addAttribute("funeralInformational", funeralInformationServices.getFuneralInformationList());
        model.addAttribute("FuneralInformationCreateDto", new FuneralInformationCreateDto());
        return "FuneralInformation/FuneralInformationList";
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
        //TODO: Add logic
        model.addAttribute("status", "Created");
        model.addAttribute("clients", clientServices.getClientsDto());
        model.addAttribute("flowers", flowerServices.GetFlowersOfUser());
        model.addAttribute("burialTypes", burialTypeServices.getBurialTypesDtoOfUser());
        model.addAttribute("FuneralInformationCreateDto", funeralInformationCreateDto);
        //TODO: change date do dateTime!
        return "FuneralInformation/FuneralInformationAdd";
    }
}

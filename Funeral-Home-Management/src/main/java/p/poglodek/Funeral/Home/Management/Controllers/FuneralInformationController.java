package p.poglodek.Funeral.Home.Management.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import p.poglodek.Funeral.Home.Management.Services.FuneralInformationServices;

@Controller
@AllArgsConstructor
@RequestMapping("FuneralInformation")
public class FuneralInformationController {

    private FuneralInformationServices funeralInformationServices;

    @GetMapping("")
    public String getFuneralInformation(Model model){
        model.addAttribute("funeralInformational", funeralInformationServices.getFuneralInformationList());
        return "FuneralInformation/FuneralInformationList";
    }
}

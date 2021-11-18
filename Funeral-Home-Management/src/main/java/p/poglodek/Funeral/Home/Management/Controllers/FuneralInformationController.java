package p.poglodek.Funeral.Home.Management.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("FuneralInformation")
public class FuneralInformationController {

    @GetMapping("")
    public String getFuneralInformation(Model model){
        //TODO: add services to get funeral info
        model.addAttribute("funeralInformation", "");
        return "";
    }
}

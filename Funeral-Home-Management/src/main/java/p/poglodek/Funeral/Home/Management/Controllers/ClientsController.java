package p.poglodek.Funeral.Home.Management.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import p.poglodek.Funeral.Home.Management.Services.ClientServices;

@Controller
@AllArgsConstructor
@RequestMapping("/client")
public class ClientsController {

    private ClientServices clientServices;

    @GetMapping("")
    public String clientList(Model model){
        model.addAttribute("clients", clientServices.getClientsDto());
        return "client/clientList";
    }
    @GetMapping("{id}")
    public String clientInfo(@PathVariable("id") String id, Model model){
        model.addAttribute("client", clientServices.getClientDto(id));
        return "client/clientInfo";
    }
}

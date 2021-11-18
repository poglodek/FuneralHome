package p.poglodek.Funeral.Home.Management.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.poglodek.Funeral.Home.Management.Dto.Client.ClientDto;
import p.poglodek.Funeral.Home.Management.Enum.CrudEnum;
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
    @GetMapping("add")
    public String addClient(Model model){
        model.addAttribute("status","Add new Client");
        model.addAttribute("clientDto", new ClientDto());
        return "client/ClientAdd";
    }
    @PostMapping("add")
    public String addClient(Model model, @ModelAttribute ClientDto clientDto){
        var result = clientServices.addClient(clientDto);
        if (result == CrudEnum.UPDATED)
            return "redirect:/client/";
        else if(result == CrudEnum.INVALID_FIRST_NAME)
            model.addAttribute("status","Invalid First Name");
        else if(result == CrudEnum.INVALID_LAST_NAME)
            model.addAttribute("status","Invalid Last Name");
        else if(result == CrudEnum.INVALID_EMAIL)
            model.addAttribute("status","Invalid Email");
        else if(result == CrudEnum.INVALID_PHONE)
            model.addAttribute("status","Invalid PHONE");
        else
            model.addAttribute("status","You Cannot add this client");
        model.addAttribute("clientDto",clientDto);
        return "client/ClientAdd";
    }
    @GetMapping("edit/{id}")
    public String editClient(@PathVariable("id") String id, Model model){
        ClientDto clientDto = clientServices.getClientDto(id);
        model.addAttribute("status","Edit Client");
        model.addAttribute("clientDtoId",id);
        model.addAttribute("clientDto", clientDto);
        return "client/ClientEdit";
    }
    @PostMapping("edit/{id}")
    public String editClient(@PathVariable("id") String id, Model model, @ModelAttribute ClientDto clientDto){
        var result = clientServices.editClient(clientDto);
        if (result == CrudEnum.INVALID_FIRST_NAME)
            model.addAttribute("status", "Invalid Client First Name");
        else if(result == CrudEnum.INVALID_LAST_NAME)
            model.addAttribute("status", "Invalid Client Last Name");
        else if(result == CrudEnum.INVALID_EMAIL)
            model.addAttribute("status", "Invalid Client Email");
        else if(result == CrudEnum.INVALID_PHONE)
            model.addAttribute("status", "Invalid Phone Email");
        else if(result == CrudEnum.UPDATED)
            return "redirect:/client/";
        else
            model.addAttribute("status", "Cannot update Client");
        model.addAttribute("clientDtoId",id);
        model.addAttribute("clientDto", clientDto);
        return "client/ClientEdit";
    }
}

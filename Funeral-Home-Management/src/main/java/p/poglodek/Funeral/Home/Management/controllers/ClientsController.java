package p.poglodek.Funeral.Home.Management.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/client")
public class ClientsController {


    @GetMapping("")
    public String all(){
        return "client/clientList";
    }
}

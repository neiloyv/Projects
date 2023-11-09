package neilo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping("/clients")
    public String getClients() {
        return "clients";
    }


    @GetMapping("/clients/add")
    public String getClientAdd() {

        return "client_add";
    }




}

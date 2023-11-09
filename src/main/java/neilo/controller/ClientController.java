package neilo.controller;

import lombok.RequiredArgsConstructor;
import neilo.dto.ClientDto;
import neilo.dto.ClientReadDto;
import neilo.dto.GroupReadDto;
import neilo.service.ClientService;
import neilo.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ClientController {

    private final ClientService clientService;
    private final GroupService groupService;

    @GetMapping("/clients")
    public String getClients(Model model) {
        List<ClientReadDto> clients = clientService.findAll();

        model.addAttribute("clients", clients);

        return "clients";
    }


    @GetMapping("/client/add")
    public String getClientAdd(Model model) {
        List<GroupReadDto> groups = groupService.getAllGroups();

        model.addAttribute("groups", groups);

        return "client_add";
    }

    @PostMapping("/client/add")
    public String addClient(Model model,
                            @ModelAttribute @Validated ClientDto clientDto) {

        clientService.save(clientDto);

        return "redirect:/clients";
    }

    @GetMapping("/client/{id}")
    public String getClient(Model model,
                            @PathVariable("id") Long id) {
        ClientReadDto client = clientService.findById(id);

        model.addAttribute("client", client);

        return "client";
    }

    @PostMapping("/client/{id}/delete")
    public String deleteClient(@PathVariable("id") Long id) {
        clientService.delete(id);

        return "redirect:/clients";
    }

    @GetMapping("/client/{id}/edit")
    public String getEditClient(Model model,
                                @PathVariable("id") Long id) {
        ClientReadDto client = clientService.findById(id);
        List<GroupReadDto> groups = groupService.getAllGroups();

        model.addAttribute("client", client);
        model.addAttribute("groups", groups);

        return "client_edit";
    }

    @PostMapping("/client/{id}/edit")
    public String editClient(@ModelAttribute @Validated ClientDto clientDto) {
        clientService.update(clientDto);

        return String.format("redirect:/client/%d", clientDto.getId());
    }


}

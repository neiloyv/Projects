package neilo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CraneController {

    @GetMapping("/crane")
    public String getCrane() {
        return "crane";
    }

}

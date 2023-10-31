package neilo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JournalController {

    @GetMapping("/journal")
    public String getJournal() {
        return "journal";
    }
}

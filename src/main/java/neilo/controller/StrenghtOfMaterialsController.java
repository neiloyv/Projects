package neilo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StrenghtOfMaterialsController {

    @GetMapping("/strength_of_materials")
    public String getStrengthOfMaterials() {
        return "strength_of_materials";
    }
}

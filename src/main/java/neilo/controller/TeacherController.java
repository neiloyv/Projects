package neilo.controller;

import lombok.RequiredArgsConstructor;
import neilo.dto.TeacherDto;
import neilo.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public String getTeachers(Model model) {
        List<TeacherDto> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @PostMapping("/add")
    public String addTeacher(Model model, @ModelAttribute TeacherDto teacherDto) {
        teacherService.save(teacherDto);
        return "redirect:/teachers";
    }
}

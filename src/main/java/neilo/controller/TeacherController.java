package neilo.controller;

import lombok.RequiredArgsConstructor;
import neilo.dto.TeacherDto;
import neilo.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/teachers")
    public String getTeachers(Model model) {
        List<TeacherDto> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @PostMapping("/")
    public String addTeacher(Model model, @ModelAttribute TeacherDto teacherDto) {
        teacherService.save(teacherDto);
        return "redirect:/teachers";
    }
}

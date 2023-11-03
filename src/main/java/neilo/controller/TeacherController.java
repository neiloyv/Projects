package neilo.controller;

import lombok.RequiredArgsConstructor;
import neilo.dto.TeacherDto;
import neilo.entity.Teacher;
import neilo.mapper.TeacherDtoMapper;
import neilo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
    public String addTeacher(Model model,
                             @ModelAttribute TeacherDto teacherDto) {
        teacherService.save(teacherDto);
        return "redirect:/teachers";
    }

    @GetMapping("/{id}")
    public String getTeacher(Model model,
                             @PathVariable("id") Long id) {
        return teacherService.findById(id)
                .map(teacher -> {
                    TeacherDto teacherDto = new TeacherDtoMapper().map(teacher);
                    model.addAttribute("teacher", teacherDto);

                    return "teacher";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}/update")
    public String updateTeacher(Model model,
                                @PathVariable("id") Long id,
                                @ModelAttribute TeacherDto teacherDto) {
        teacherService.update(id, teacherDto);

        return "redirect:/teachers";
    }
}

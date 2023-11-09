package neilo.controller;

import lombok.RequiredArgsConstructor;
import neilo.dto.TeacherDto;
import neilo.entity.Teacher;
import neilo.mapper.TeacherDtoMapper;
import neilo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/teacher/add")
    public String getTeacherAdd() {

        return "teacher_add";
    }

    @PostMapping("/teacher/add")
    public String addTeacher(Model model,
                             @ModelAttribute @Validated TeacherDto teacherDto) {
        teacherService.save(teacherDto);
        return "redirect:/teachers";
    }

    @GetMapping("/teacher/{id}")
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

    @GetMapping("/teacher/{id}/edit")
    public String getTeacherEdit(Model model,
                                 @PathVariable("id") Long id) {

        return teacherService.findById(id)
                .map(teacher -> {
                    TeacherDto teacherDto = new TeacherDtoMapper().map(teacher);
                    model.addAttribute("teacher", teacherDto);

                    return "teacher_edit";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/teacher/{id}/update")
    public String updateTeacher(@ModelAttribute @Validated TeacherDto teacherDto) {
        teacherService.update(teacherDto);

        return String.format("redirect:/teacher/%d", teacherDto.getId());
    }

    @PostMapping("/teacher/{id}/delete")
    public String deleteTeacher(@PathVariable("id") Long id) {
        teacherService.delete(id);

        return "redirect:/teachers";
    }
}

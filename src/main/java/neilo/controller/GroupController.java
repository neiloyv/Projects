package neilo.controller;

import lombok.RequiredArgsConstructor;
import neilo.dto.GroupDto;
import neilo.dto.GroupReadDto;
import neilo.dto.TeacherDto;
import neilo.entity.Group;
import neilo.entity.Teacher;
import neilo.service.GroupService;
import neilo.service.TeacherService;
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
public class GroupController {

    private final GroupService groupService;
    private final TeacherService teacherService;

    @GetMapping("/groups")
    public String getGroups(Model model) {
        List<GroupReadDto> groups = groupService.getAllGroups();

        model.addAttribute("groups", groups);

        return "groups";
    }

    @GetMapping("/group/{id}")
    public String getGroup(Model model,
                           @PathVariable("id") Integer id) {
        GroupReadDto groupReadDto = groupService.getById(id);

        model.addAttribute("group", groupReadDto);

        return "group";
    }

    @GetMapping("/groups/add")
    public String getGroupAdd(Model model) {
        List<TeacherDto> teachers = teacherService.findAll();

        model.addAttribute("teachers", teachers);

        return "group_add";
    }

    @PostMapping("/group/add")
    public String addGroup(@ModelAttribute @Validated GroupDto groupDto) {
        groupService.saveGroup(groupDto);

        return "redirect:/groups";
    }

    @PostMapping("/group/{id}/delete")
    public String deleteGroup(@PathVariable("id") Integer id) {
        groupService.delete(id);

        return "redirect:/groups";
    }

    @GetMapping("/group/{id}/edit")
    public String getGroupEdit(Model model, @PathVariable("id") Integer id) {
        GroupReadDto groupReadDto = groupService.getById(id);
        List<TeacherDto> teachers = teacherService.findAll();

        model.addAttribute("group", groupReadDto);
        model.addAttribute("teachers", teachers);

        return "group_edit";
    }

    @PostMapping("/group/{id}/edit")
    public String editGroup(@ModelAttribute @Validated GroupDto groupDto) {
        groupService.edit(groupDto);

        return String.format("redirect:/group/%d", groupDto.getId());
    }


}

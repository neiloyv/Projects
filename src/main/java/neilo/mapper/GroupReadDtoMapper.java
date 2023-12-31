package neilo.mapper;

import lombok.RequiredArgsConstructor;
import neilo.dto.GroupReadDto;
import neilo.entity.Group;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GroupReadDtoMapper implements Mapper<Group, GroupReadDto> {

    private final TeacherDtoMapper teacherDtoMapper;

    @Override
    public GroupReadDto map(Group group) {
        String fullname = group.getTeacher().getLastname()
                + " "
                + group.getTeacher().getFirstname()
                + " - "
                + group.getName();

        return GroupReadDto.builder()
                .id(group.getId())
                .name(group.getName())
                .teacherDto(teacherDtoMapper.map(group.getTeacher()))
                .fullname(fullname)
                .build();
    }
}

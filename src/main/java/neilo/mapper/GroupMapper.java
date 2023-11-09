package neilo.mapper;

import lombok.RequiredArgsConstructor;
import neilo.dto.GroupDto;
import neilo.entity.Group;
import neilo.entity.Teacher;
import neilo.repository.TeacherRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GroupMapper implements Mapper<GroupDto, Group> {

    private final TeacherRepository teacherRepository;

    @Override
    public Group map(GroupDto groupDto) {
        Teacher teacher = teacherRepository.findById(groupDto.getTeacherId()).orElseThrow();

        return Group.builder()
                .name(groupDto.getName())
                .teacher(teacher)
                .build();
    }
}

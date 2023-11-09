package neilo.mapper;

import lombok.RequiredArgsConstructor;
import neilo.dto.GroupDto;
import neilo.entity.Group;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GroupDtoMapper implements Mapper<Group, GroupDto> {

    @Override
    public GroupDto map(Group group) {
        return GroupDto.builder()
                .id(group.getId())
                .name(group.getName())
                .teacherId(group.getTeacher().getId())
                .build();
    }
}

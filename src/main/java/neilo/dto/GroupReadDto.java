package neilo.dto;

import lombok.Builder;
import lombok.Value;
import neilo.entity.Teacher;

@Value
@Builder
public class GroupReadDto {

    Integer id;

    String name;

    TeacherDto teacherDto;

    String fullname;
}

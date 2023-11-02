package neilo.mapper;

import neilo.dto.TeacherDto;
import neilo.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherDtoMapper implements Mapper<Teacher, TeacherDto> {
    @Override
    public TeacherDto map(Teacher teacher) {
        return TeacherDto.builder()
                .id(teacher.getId())
                .firstname(teacher.getFirstname())
                .lastname(teacher.getLastname())
                .middlename(teacher.getMiddlename())
                .birthday(teacher.getBirthday())
                .passport(teacher.getPassport())
                .authority(teacher.getAuthority())
                .dateOfIssue(teacher.getDateOfIssue())
                .taxNumber(teacher.getTaxNumber())
                .build();
    }
}

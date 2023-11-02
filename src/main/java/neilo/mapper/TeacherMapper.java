package neilo.mapper;

import neilo.dto.TeacherDto;
import neilo.entity.Teacher;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TeacherMapper implements Mapper<TeacherDto, Teacher> {
    @Override
    public Teacher map(TeacherDto teacherDto) {
        Teacher teacher = Teacher.builder()
                .firstname(teacherDto.getFirstname())
                .lastname(teacherDto.getLastname())
                .middlename(teacherDto.getMiddlename())
                .birthday(teacherDto.getBirthday())
                .passport(teacherDto.getPassport())
                .authority(teacherDto.getAuthority())
                .dateOfIssue(teacherDto.getDateOfIssue())
                .taxNumber(teacherDto.getTaxNumber())
                .build();
        return teacher;
    }
}

package neilo.service;

import lombok.RequiredArgsConstructor;
import neilo.dto.TeacherDto;
import neilo.entity.Teacher;
import neilo.mapper.TeacherDtoMapper;
import neilo.mapper.TeacherMapper;
import neilo.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final TeacherDtoMapper teacherDtoMapper;

    public List<TeacherDto> findAll() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherDtoMapper::map)
                .collect(Collectors.toList());
    }

    @Transactional
    public Teacher save(TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.map(teacherDto);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return savedTeacher;
    }

    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    @Transactional
    public Optional<TeacherDto> update(Long id, TeacherDto teacherDto) {
        return findById(id)
                .map(teacher -> {
                    teacher.setFirstname(teacherDto.getFirstname());
                    teacher.setLastname(teacherDto.getLastname());
                    teacher.setMiddlename(teacherDto.getMiddlename());
                    teacher.setBirthday(teacherDto.getBirthday());
                    teacher.setPassport(teacherDto.getPassport());
                    teacher.setAuthority(teacherDto.getAuthority());
                    teacher.setDateOfIssue(teacherDto.getDateOfIssue());
                    teacher.setTaxNumber(teacherDto.getTaxNumber());
                    return teacher;
                })
                .map(teacherRepository::saveAndFlush)
                .map(teacherDtoMapper::map);
    }


}

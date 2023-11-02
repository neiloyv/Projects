package neilo.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class TeacherDto {

    Long id;
    String firstname;
    String lastname;
    String middlename;
    LocalDate birthday;
    String passport;
    String authority;
    LocalDate dateOfIssue;
    String taxNumber;

}

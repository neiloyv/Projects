package neilo.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
@Builder
public class TeacherDto {

    Long id;
    @Size(min = 3, max = 64, message = "The first name must have a size between 3 and 64 characters")
    String firstname;

    @Size(min = 3, max = 64, message = "The last name must have a size between 3 and 64 characters")
    String lastname;

    @Size(min = 3, max = 64, message = "The middle name must have a size between 3 and 64 characters")
    String middlename;

    @Past(message = "The Birthday can not be in the future")
    LocalDate birthday;

    @NotBlank
    String passport;

    @NotBlank
    String authority;

    @Past(message = "The date of issue can not be in the future")
    LocalDate dateOfIssue;

    @Size(min = 10, max = 10, message = "The tax number must have a size equal to 10 characters")
    String taxNumber;


}

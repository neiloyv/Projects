package neilo.dto;


import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
@Builder
public class ClientDto {

    Long id;

    @Size(min = 3, max = 64, message = "The first name must have a size between 3 and 64 characters")
    String firstname;

    @Size(min = 3, max = 64, message = "The last name must have a size between 3 and 64 characters")
    String lastname;

    @Size(min = 3, max = 64, message = "The middle name must have a size between 3 and 64 characters")
    String middlename;

    @Past(message = "The Birthday can not be in the future")
    LocalDate birthday;

    @Size(min = 3, max = 64, message = "The first name must have a size between 3 and 64 characters")
    String parentFirstname;

    @Size(min = 3, max = 64, message = "The last name must have a size between 3 and 64 characters")
    String parentLastname;

    @Size(min = 3, max = 64, message = "The middle name must have a size between 3 and 64 characters")
    String parentMiddlename;

    @Size(min = 13, max = 13, message = "The phone must have a size equals 13 characters. " +
            "Phone number must have next format pattern: +380#########")
    String parentPhone;

    @NotNull
    Integer groupId;
}

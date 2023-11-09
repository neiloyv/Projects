package neilo.dto;


import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class ClientReadDto {

    Long id;
    String firstname;
    String lastname;
    String middlename;
    LocalDate birthday;
    String parentFirstname;
    String parentLastname;
    String parentMiddlename;
    String parentPhone;
    GroupReadDto groupReadDto;
}

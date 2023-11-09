package neilo.dto;

import lombok.Builder;
import lombok.Value;
import neilo.entity.Teacher;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
@Builder
public class GroupDto {

    Integer id;

    @Size(min = 3, max = 64, message = "The name must have a size between 3 and 64 characters")
    String name;

    @NotNull
    Long teacherId;
}

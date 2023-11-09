package neilo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String middlename;

    private LocalDate birthday;

    private String parentFirstname;

    private String parentLastname;

    private String parentMiddlename;

    private String parentPhone;

    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Group group;

}

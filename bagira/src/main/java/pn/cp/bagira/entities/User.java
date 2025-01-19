package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@Builder
@ToString
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Comp comp;

    @OneToMany( mappedBy = "user")
    private List<Application> applicationList;

}

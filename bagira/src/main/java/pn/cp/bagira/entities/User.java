package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@ToString
public class User  implements Serializable {

    @Id
  //  @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    private Comp comp;

    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL)
    private List<Application> applicationList;

    @PrePersist
    public  void prePersist(){id=UUID.randomUUID().toString();}
}

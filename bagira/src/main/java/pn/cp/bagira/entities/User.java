package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
//@ToString
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(
            cascade = CascadeType.ALL)
    private Comp comp;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "USER_APP",
            joinColumns = @JoinColumn(   name = "UID"),
            inverseJoinColumns = @JoinColumn(name = "AID")

    )
    private List<Application> applicationList;

}

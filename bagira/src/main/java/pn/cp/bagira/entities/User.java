package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "users")
@Data
//@ToString
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_COMP",
            joinColumns = @JoinColumn(name = "UID"),
            inverseJoinColumns = @JoinColumn(name = "CID")
    )
    private Comp comp;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "USER_APP",
            joinColumns = @JoinColumn(name = "UID"),
            inverseJoinColumns = @JoinColumn(name = "AID")
    )
    private List<Application> applicationList;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @MapKeyJoinColumn(name = "AID")
    @JoinTable(
            name = "APP_PERM",
            joinColumns = @JoinColumn(name = "UID"),
            inverseJoinColumns = @JoinColumn(name = "PID")
    )
    private Map<Application, Permission> applicationPermissionMap;
}

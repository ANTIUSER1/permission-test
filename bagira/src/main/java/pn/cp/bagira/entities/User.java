package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Comp computer;

    @ManyToMany
    @MapKeyJoinColumn( name = "APP_ID")
    @JoinTable( name = "_COMP_USER_APP_PERM_" ,
            joinColumns =@JoinColumn( name = "USER_ID"),
            inverseJoinColumns = @JoinColumn( name = "PERM_ID")
    )
    private Map<Application, Permission> permitionMap;
}

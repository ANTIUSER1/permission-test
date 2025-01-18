package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "comps")
@Data
@ToString
public class Comp {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToMany
    private List<User> compUserList;

    @ManyToMany
    @MapKeyJoinColumn( name = "APP_ID")
    @JoinTable( name = "_COMP_APP_PERM_" ,
            joinColumns =@JoinColumn( name = "COMP_ID"),
    inverseJoinColumns = @JoinColumn( name = "PERM_ID")
    )
   private Map<Application, Permission> permitionMap;

}

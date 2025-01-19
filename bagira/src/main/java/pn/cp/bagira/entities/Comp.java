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
@Table(name = "comps")
@Data
@Builder
@ToString
public class Comp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String mac;


    @OneToMany(mappedBy = "comp")
    private List<User> compUserList;

//    @ManyToMany
//    @MapKeyJoinColumn( name = "APP_ID")
//    @JoinTable( name = "_COMP_USER_APP_PERM_" ,
//            joinColumns =@JoinColumn( name = "COMP_ID"),
//    inverseJoinColumns = @JoinColumn( name = "PERM_ID")
//    )
//   private Map<Application, Permission> permitionMap;



}

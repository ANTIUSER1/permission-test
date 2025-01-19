package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "comps")
@Data
public class Comp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mac;

    @OneToMany(mappedBy = "comp")
    private Set<User> userSet;

//



}

package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "apps")
@Data
//@ToString
public class Application  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    @ManyToMany(// mappedBy = "applicationList",
           cascade = CascadeType.ALL
    )
    private List<User> userList;
}

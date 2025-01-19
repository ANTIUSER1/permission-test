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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @OneToMany( mappedBy = "user"//,
        //    cascade = CascadeType.ALL
    )
  //  @JoinColumn( name = "user_id")
    private List<Application> applicationList;

}

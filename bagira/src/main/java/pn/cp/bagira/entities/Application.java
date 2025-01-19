package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "apps")
@Data
//@ToString
public class Application  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private byte permValue;

    @ManyToOne(
           // cascade = CascadeType.ALL
    )
    @JoinColumn( name = "user_id")
    private User user;
}

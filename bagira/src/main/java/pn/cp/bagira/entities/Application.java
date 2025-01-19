package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "apps")
@Data
@ToString
public class Application  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private byte permValue;

    @ManyToOne( cascade = CascadeType.ALL)
    private User user;
}

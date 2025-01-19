package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "perms")
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private byte value;

}

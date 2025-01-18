package pn.cp.bagira.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "apps")
@Data
@ToString
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


}

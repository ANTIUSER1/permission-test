package pns.tst.cutr_list.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Curruncy {
    /**
     * identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * name
     */
    private String name;
    /**
     * course list
     */
    @OneToMany( mappedBy = "curruncy", cascade = CascadeType.ALL)
    private List<Course> corseList;
}

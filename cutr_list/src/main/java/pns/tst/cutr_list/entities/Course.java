package pns.tst.cutr_list.entities;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
//@ToString
public class Course {

    /**
     * identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * course value
     */
    private double value;
    /**
     * date when course set
     */
    private LocalDate courseDate;
    /**
     * link to currency
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Currency currency;

}

package pns.tst.cutr_list.entities;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
//@ToString
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
    @OneToMany(mappedBy = "curruncy", cascade = CascadeType.ALL)
    private List<Course> courseList;

    public  void addCourse(Course course){
        if(courseList ==null ) courseList =new ArrayList<>();
        courseList.add(course);
    }
}

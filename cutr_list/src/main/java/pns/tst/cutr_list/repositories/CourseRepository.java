package pns.tst.cutr_list.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pns.tst.cutr_list.entities.Course;

import java.util.List;

/**
 * repo for Course
 */
@Transactional
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query(value = " select * from course where currency_id = ?1 ", nativeQuery = true)
    public List<Course> getCuurseListByCurrencyId(@Param("id") Long id);
}

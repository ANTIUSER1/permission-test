package pns.tst.cutr_list.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pns.tst.cutr_list.entities.Course;

/**
 * repo for Course
 */
@Transactional
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}

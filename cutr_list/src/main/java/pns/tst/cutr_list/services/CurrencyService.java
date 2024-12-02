package pns.tst.cutr_list.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pns.tst.cutr_list.entities.Course;
import pns.tst.cutr_list.entities.Curruncy;

/**
 * creating currency
 */
@Service
@Slf4j
public class CurrencyService {

    @Autowired
    private CourseService courseService;

    public Curruncy create(String currName) {
        Curruncy result = new Curruncy();
        result.setName(currName);
        log.info("Create Currency "+result+"  Adding Course");
        for (long k = -20; k < 20; k++) {
            Course course = courseService.create(k);
            course.setCurruncy(result);
            result.addCourse(course );

        }
        return result;
    }
}

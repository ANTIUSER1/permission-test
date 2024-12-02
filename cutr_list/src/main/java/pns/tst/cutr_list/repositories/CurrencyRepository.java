package pns.tst.cutr_list.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pns.tst.cutr_list.entities.Course;
import pns.tst.cutr_list.entities.Curruncy;

@Transactional
@Repository
public interface CurrencyRepository extends CrudRepository<Curruncy, Long> {
}

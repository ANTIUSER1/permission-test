package pns.tst.cutr_list.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pns.tst.cutr_list.entities.Currency;

/**
 * repo for Curruncy
 */
@Transactional
@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {
}

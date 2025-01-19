package pn.cp.bagira.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import pn.cp.bagira.entities.Comp;

import java.util.UUID;

@Transactional
public interface CompRepository extends CrudRepository<Comp, Long> {


}

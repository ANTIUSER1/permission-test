package pn.cp.bagira.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import pn.cp.bagira.entities.Application;

import java.util.UUID;

@Transactional
public interface ApplicationRepository  extends CrudRepository<Application, UUID> {
}

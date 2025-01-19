package pn.cp.bagira.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pn.cp.bagira.entities.Application;

@Transactional
public interface ApplicationRepository  extends CrudRepository<Application, String> {

    @Query( value = "  SELECT * FROM apps WHERE  id = :id ", nativeQuery = true)
    public Application getById(@Param("id") String uid);
}

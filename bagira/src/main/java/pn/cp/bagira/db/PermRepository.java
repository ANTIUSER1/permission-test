package pn.cp.bagira.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pn.cp.bagira.entities.Application;
import pn.cp.bagira.entities.Permission;

@Transactional
public interface PermRepository extends CrudRepository<Permission, Long> {

    @Query(value = "  SELECT * FROM perms WHERE  id = :id ", nativeQuery = true)
    Application getById(@Param("id") Long uid);


}

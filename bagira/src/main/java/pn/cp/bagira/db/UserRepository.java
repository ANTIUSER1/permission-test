package pn.cp.bagira.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pn.cp.bagira.entities.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    @Query( value = "  SELECT * FROM users WHERE  id = :id ", nativeQuery = true)
    public User getById(@Param("id") Long uid);
}

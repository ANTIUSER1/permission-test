package pn.cp.bagira.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pn.cp.bagira.entities.User;

import java.util.UUID;

@Transactional
public interface UserRepository extends CrudRepository<User, String> {

    @Query( value = "  SELECT * FROM users WHERE  id = :id ", nativeQuery = true)
    public User getUserById(@Param("id") String uid);
}

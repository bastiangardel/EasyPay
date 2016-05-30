package ch.bastiangardel.easypay.repository;

import ch.bastiangardel.easypay.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * DAO for {@link User}.
 */
public interface UserRepository extends CrudRepository<User,Long> {

    User findByEmail(String email);

    User findByEmailAndActive(String email, boolean active);

}

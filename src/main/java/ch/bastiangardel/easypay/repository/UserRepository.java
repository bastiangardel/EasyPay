package ch.bastiangardel.easypay.repository;

import ch.bastiangardel.easypay.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO for {@link User}.
 */
@Transactional
public interface UserRepository extends CrudRepository<User,Long> {

    User findByEmail(String email);

    User findByEmailAndActive(String email, boolean active);

}

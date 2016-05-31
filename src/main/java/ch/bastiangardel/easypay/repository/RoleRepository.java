package ch.bastiangardel.easypay.repository;

import ch.bastiangardel.easypay.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO for {@link Role}.
 */
@Transactional
public interface RoleRepository extends CrudRepository<Role,Long> {

}

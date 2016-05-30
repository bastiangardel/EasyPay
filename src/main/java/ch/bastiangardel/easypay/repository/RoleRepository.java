package ch.bastiangardel.easypay.repository;

import ch.bastiangardel.easypay.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * DAO for {@link Role}.
 */
public interface RoleRepository extends CrudRepository<Role,Long> {

}

package ch.bastiangardel.easypay.repository;

import ch.bastiangardel.easypay.model.Permission;
import org.springframework.data.repository.CrudRepository;

/**
 * DAO for {@link Permission}.
 */
public interface PermissionRepository extends CrudRepository<Permission,Long> {

}

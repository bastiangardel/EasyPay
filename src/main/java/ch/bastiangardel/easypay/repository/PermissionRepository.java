package ch.bastiangardel.easypay.repository;

import ch.bastiangardel.easypay.model.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO for {@link Permission}.
 */
@Transactional
public interface PermissionRepository extends CrudRepository<Permission,Long> {

}

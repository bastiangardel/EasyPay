package ch.bastiangardel.easypay.repository;

import ch.bastiangardel.easypay.model.CheckOut;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bastiangardel on 16.05.16.
 */
/**
 * DAO for {@link CheckOut}.
 */

@Transactional
public interface CheckOutRepository extends CrudRepository<CheckOut,Long> {

    CheckOut findByUuid(String uuid);
}

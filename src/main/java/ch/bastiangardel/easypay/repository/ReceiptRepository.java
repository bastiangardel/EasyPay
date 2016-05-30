package ch.bastiangardel.easypay.repository;

import ch.bastiangardel.easypay.model.Receipt;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by bastiangardel on 16.05.16.
 */
/**
 * DAO for {@link Receipt}.
 */
public interface ReceiptRepository extends CrudRepository<Receipt,Long> {


}

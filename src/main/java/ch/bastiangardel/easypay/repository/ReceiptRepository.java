package ch.bastiangardel.easypay.repository;

import ch.bastiangardel.easypay.model.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bastiangardel on 16.05.16.
 */
/**
 * DAO for {@link Receipt}.
 */
@Transactional
public interface ReceiptRepository extends CrudRepository<Receipt,Long> {


}

package com.github.pires.example.repository;

import com.github.pires.example.model.Receipt;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

/**
 * Created by bastiangardel on 16.05.16.
 */
/**
 * DAO for {@link Receipt}.
 */
public interface ReceiptRepository extends OrientObjectRepository<Receipt> {

}

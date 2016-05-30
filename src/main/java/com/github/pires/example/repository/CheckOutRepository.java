package com.github.pires.example.repository;

import com.github.pires.example.model.CheckOut;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.cdi.Eager;
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

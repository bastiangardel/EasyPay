package com.github.pires.example.repository;

import com.github.pires.example.model.CheckOut;
import org.springframework.data.orient.commons.repository.annotation.FetchPlan;
import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.data.repository.cdi.Eager;

/**
 * Created by bastiangardel on 16.05.16.
 */
/**
 * DAO for {@link CheckOut}.
 */


public interface CheckOutRepository extends OrientObjectRepository<CheckOut> {

    CheckOut findByUuid(String uuid);
}

package com.github.pires.example.repository;

import com.github.pires.example.model.CheckOut;
import com.github.pires.example.model.Permission;
import com.github.pires.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

/**
 * Created by bastiangardel on 16.05.16.
 */
/**
 * DAO for {@link CheckOut}.
 */
public interface CheckOutRepository extends OrientObjectRepository<CheckOut> {


}

package com.github.pires.example.repository;

import com.github.pires.example.model.Permission;
import org.springframework.data.repository.CrudRepository;

/**
 * DAO for {@link Permission}.
 */
public interface PermissionRepository extends CrudRepository<Permission,Long> {

}

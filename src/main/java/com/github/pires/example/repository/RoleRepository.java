package com.github.pires.example.repository;

import com.github.pires.example.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * DAO for {@link Role}.
 */
public interface RoleRepository extends CrudRepository<Role,Long> {

}

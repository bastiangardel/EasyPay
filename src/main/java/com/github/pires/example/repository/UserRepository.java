package com.github.pires.example.repository;

import com.github.pires.example.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * DAO for {@link User}.
 */
public interface UserRepository extends CrudRepository<User,Long> {

    User findByEmail(String email);

    User findByEmailAndActive(String email, boolean active);

}

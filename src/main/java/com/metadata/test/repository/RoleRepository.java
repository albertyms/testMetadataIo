package com.metadata.test.repository;

import com.metadata.test.entity.Role;
import com.metadata.test.util.RoleEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(RoleEnum name);

}

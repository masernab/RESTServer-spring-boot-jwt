package com.miguel.springjwt.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miguel.springjwt.models.ERole;
import com.miguel.springjwt.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}

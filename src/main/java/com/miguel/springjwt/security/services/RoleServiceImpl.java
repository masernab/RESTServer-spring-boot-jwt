package com.miguel.springjwt.security.services;

import com.miguel.springjwt.models.ERole;
import com.miguel.springjwt.models.Role;
import com.miguel.springjwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public ResponseEntity<Role> addRole(Role role) {
        try {
            Role newRole = roleRepository.save(role);
            return new ResponseEntity<Role>(newRole, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Optional<Role>> getRoleByName(ERole name) {
        try {
            Optional<Role> role = roleRepository.findByName(name);
            if(role.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<Optional<Role>>(role, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.miguel.springjwt.controllers;

import com.miguel.springjwt.models.ERole;
import com.miguel.springjwt.models.Role;
import com.miguel.springjwt.security.services.RoleServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api/v1/role")
@RestController
@CrossOrigin("*")
public class RoleController {

    private final RoleServiceImpl roleService;

    @Autowired
    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @GetMapping(path = "{name}")
    public ResponseEntity<Optional<Role>> addRole(@PathVariable("name") ERole name) {
        return roleService.getRoleByName(name);
    }
}

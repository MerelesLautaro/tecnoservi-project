package com.lautadev.tecnoservi_project.controller;

import com.lautadev.tecnoservi_project.model.Role;
import com.lautadev.tecnoservi_project.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<String> saveRole(@RequestBody Role role){
        roleService.saveRole(role);
        return ResponseEntity.ok("Role saved successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<List<Role>> getRoles(){
        return ResponseEntity.ok(roleService.getRoles());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Role> findRole(@PathVariable Long id){
        Optional<Role> role = roleService.findRole(id);
        return role.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return ResponseEntity.ok("Role deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Role> editRole(@PathVariable Long id, @RequestBody Role role){
        return ResponseEntity.ok(roleService.editRole(id,role));
    }
}

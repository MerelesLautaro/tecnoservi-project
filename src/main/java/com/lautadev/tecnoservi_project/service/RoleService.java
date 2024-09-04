package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.Permission;
import com.lautadev.tecnoservi_project.model.Role;
import com.lautadev.tecnoservi_project.repository.IRoleRepository;
import com.lautadev.tecnoservi_project.throwable.EntityNotFoundException;
import com.lautadev.tecnoservi_project.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public Role saveRole(Role role) {
        Set<Permission> permissionsList = new HashSet<>();

        for(Permission permission: role.getPermissionSet() ){
            Permission readPermission = permissionService.findPermission(permission.getId()).orElse(null);
            if(readPermission!=null){
                permissionsList.add(readPermission);
            }
        }

        if(!permissionsList.isEmpty())
        {
            role.setPermissionSet(permissionsList);
            return roleRepository.save(role);
        }

        return role;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findRole(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role editRole(Long id,Role role) {
        Role roleEdit = this.findRole(id).orElseThrow(() -> new EntityNotFoundException("Entity not found")) ;;

        NullAwareBeanUtils.copyNonNullProperties(role,roleEdit);

        return this.saveRole(roleEdit);
    }
}

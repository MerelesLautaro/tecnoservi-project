package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.Permission;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {
    public void savePermission(Permission permission);
    public List<Permission> getPermission();
    public Optional<Permission> findPermission(Long id);
    public void deletePermission(Long id);
    public void editPermission(Permission permission);
}

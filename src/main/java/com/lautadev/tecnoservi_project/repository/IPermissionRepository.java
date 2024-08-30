package com.lautadev.tecnoservi_project.repository;

import com.lautadev.tecnoservi_project.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission,Long> {
}

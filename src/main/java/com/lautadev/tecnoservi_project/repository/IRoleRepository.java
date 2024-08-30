package com.lautadev.tecnoservi_project.repository;

import com.lautadev.tecnoservi_project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
}

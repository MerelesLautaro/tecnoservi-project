package com.lautadev.tecnoservi_project.repository;

import com.lautadev.tecnoservi_project.model.Employed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployedRepository extends JpaRepository<Employed,Long> {
}

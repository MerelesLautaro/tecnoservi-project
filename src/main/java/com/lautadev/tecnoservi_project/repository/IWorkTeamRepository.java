package com.lautadev.tecnoservi_project.repository;

import com.lautadev.tecnoservi_project.model.WorkTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWorkTeamRepository extends JpaRepository<WorkTeam,Long> {
}

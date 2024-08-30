package com.lautadev.tecnoservi_project.repository;

import com.lautadev.tecnoservi_project.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task,Long> {
}

package com.lautadev.tecnoservi_project.repository;

import com.lautadev.tecnoservi_project.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long> {
}

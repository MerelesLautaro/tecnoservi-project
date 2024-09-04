package com.lautadev.tecnoservi_project.repository;

import com.lautadev.tecnoservi_project.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findUserEntityByUsername(String username);
}

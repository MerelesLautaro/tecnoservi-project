package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.Account;
import com.lautadev.tecnoservi_project.model.Role;
import com.lautadev.tecnoservi_project.repository.IAccountRepository;
import com.lautadev.tecnoservi_project.throwable.EntityNotFoundException;
import com.lautadev.tecnoservi_project.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IRoleService roleService;


    @Override
    public Account saveAccount(Account account) {
        Set<Role> roleList = new HashSet<>();

        account.setPassword(this.encriptPassword(account.getPassword()));

        for(Role role: account.getRoleList()){
            Role readRole = roleService.findRole(role.getId()).orElse(null);
            if(readRole!=null){
                roleList.add(readRole);
            }
        }

        if(!roleList.isEmpty()){
            account.setRoleList(roleList);
            return accountRepository.save(account);
        }

        return account;
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findAccount(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account editAccount(Long id, Account account) {
        Account accountEdit = this.findAccount(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        NullAwareBeanUtils.copyNonNullProperties(account,accountEdit);

        return this.saveAccount(accountEdit);
    }

    @Override
    public String encriptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}

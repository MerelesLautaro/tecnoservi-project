package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.Employed;
import com.lautadev.tecnoservi_project.repository.IEmployedRepository;
import com.lautadev.tecnoservi_project.throwable.EntityNotFoundException;
import com.lautadev.tecnoservi_project.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployedService implements IEmployedService {
    @Autowired
    private IEmployedRepository employedRepository;

    @Override
    public void saveEmployed(Employed employed) {
        employedRepository.save(employed);
    }

    @Override
    public List<Employed> getEmployees() {
        return employedRepository.findAll();
    }

    @Override
    public Optional<Employed> findEmployed(Long id) {
        return employedRepository.findById(id);
    }

    @Override
    public void deleteEmployed(Long id) {
        employedRepository.deleteById(id);
    }

    @Override
    public void editEmployed(Long id, Employed employed) {
        Employed employedEdit = this.findEmployed(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        NullAwareBeanUtils.copyNonNullProperties(employed,employedEdit);

        employedRepository.save(employedEdit);
    }
}

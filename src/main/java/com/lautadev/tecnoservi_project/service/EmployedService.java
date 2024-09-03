package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.dto.EmployedDTO;
import com.lautadev.tecnoservi_project.model.Employed;
import com.lautadev.tecnoservi_project.repository.IEmployedRepository;
import com.lautadev.tecnoservi_project.throwable.EntityNotFoundException;
import com.lautadev.tecnoservi_project.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<EmployedDTO> getEmployees() {
        List<Employed> employedList = employedRepository.findAll();
        List<EmployedDTO> employedDTOList = new ArrayList<>();

        for(Employed employed:employedList){
            employedDTOList.add(EmployedDTO.fromEmployed(employed));
        }

        return employedDTOList;
    }

    @Override
    public Optional<EmployedDTO> findEmployed(Long id) {
        Employed employed = employedRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return Optional.ofNullable(EmployedDTO.fromEmployed(employed));
    }

    @Override
    public void deleteEmployed(Long id) {
        employedRepository.deleteById(id);
    }

    @Override
    public void editEmployed(Long id, Employed employed) {
        Employed employedEdit = employedRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        NullAwareBeanUtils.copyNonNullProperties(employed,employedEdit);

        employedRepository.save(employedEdit);
    }
}

package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.Employed;

import java.util.List;
import java.util.Optional;

public interface IEmployedService {
    public void saveEmployed(Employed employed);
    public List<Employed> getEmployees();
    public Optional<Employed> findEmployed(Long id);
    public void deleteEmployed(Long id);
    public void editEmployed(Long id,Employed employed);
}

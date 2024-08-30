package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.WorkTeam;

import java.util.List;
import java.util.Optional;

public interface IWorkTeamService {
    public void saveWorkTeam(WorkTeam workTeam);
    public List<WorkTeam> getWorkTeams();
    public Optional<WorkTeam> findWorkTeam(Long id);
    public void deleteWorkTeam(Long id);
    public void editWorkTeam(Long id, WorkTeam workTeam);
}

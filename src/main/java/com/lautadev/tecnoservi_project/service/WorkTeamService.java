package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.WorkTeam;
import com.lautadev.tecnoservi_project.repository.IWorkTeamRepository;
import com.lautadev.tecnoservi_project.throwable.EntityNotFoundException;
import com.lautadev.tecnoservi_project.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkTeamService implements IWorkTeamService {
    @Autowired
    private IWorkTeamRepository workTeamRepository;

    @Override
    public void saveWorkTeam(WorkTeam workTeam) {
        workTeamRepository.save(workTeam);
    }

    @Override
    public List<WorkTeam> getWorkTeams() {
        return workTeamRepository.findAll();
    }

    @Override
    public Optional<WorkTeam> findWorkTeam(Long id) {
        return workTeamRepository.findById(id);
    }

    @Override
    public void deleteWorkTeam(Long id) {
        workTeamRepository.deleteById(id);
    }

    @Override
    public void editWorkTeam(Long id, WorkTeam workTeam) {
        WorkTeam workTeamEdit = this.findWorkTeam(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        NullAwareBeanUtils.copyNonNullProperties(workTeam,workTeamEdit);

        workTeamRepository.save(workTeamEdit);
    }
}

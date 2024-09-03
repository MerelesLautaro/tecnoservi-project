package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.dto.WorkTeamDTO;
import com.lautadev.tecnoservi_project.model.Employed;
import com.lautadev.tecnoservi_project.model.WorkTeam;
import com.lautadev.tecnoservi_project.repository.IWorkTeamRepository;
import com.lautadev.tecnoservi_project.throwable.EntityNotFoundException;
import com.lautadev.tecnoservi_project.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkTeamService implements IWorkTeamService {
    @Autowired
    private IWorkTeamRepository workTeamRepository;

    @Autowired
    private IEmployedService employedService;

    @Override
    @Transactional
    public void saveWorkTeam(WorkTeam workTeam) {

        for (Employed employed : workTeam.getEmployees()) {
            employed.setWorkTeam(workTeam);
            employedService.editEmployed(employed.getId(),employed);
        }

        workTeamRepository.save(workTeam);
    }

    @Override
    public List<WorkTeamDTO> getWorkTeams() {
        List<WorkTeam> workTeams = workTeamRepository.findAll();
        List<WorkTeamDTO> workTeamDTOS = new ArrayList<>();

        for (WorkTeam workTeam : workTeams) {
            workTeamDTOS.add(WorkTeamDTO.fromWorkTeam(workTeam));
        }

        return workTeamDTOS;
    }

    @Override
    public Optional<WorkTeamDTO> findWorkTeam(Long id) {
        WorkTeam workTeam = workTeamRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));
        return Optional.ofNullable(WorkTeamDTO.fromWorkTeam(workTeam));
    }

    @Override
    public void deleteWorkTeam(Long id) {
        workTeamRepository.deleteById(id);
    }

    @Override
    public void editWorkTeam(Long id, WorkTeam workTeam) {
        WorkTeam workTeamEdit = workTeamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(workTeam,workTeamEdit);

        workTeamRepository.save(workTeamEdit);
    }
}

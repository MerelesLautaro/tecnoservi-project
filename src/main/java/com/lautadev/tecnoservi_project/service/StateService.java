package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.State;
import com.lautadev.tecnoservi_project.repository.IStateRepository;
import com.lautadev.tecnoservi_project.throwable.EntityNotFoundException;
import com.lautadev.tecnoservi_project.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService implements IStateService{
    @Autowired
    private IStateRepository stateRepository;

    @Override
    public void saveState(State state) {
        stateRepository.save(state);
    }

    @Override
    public List<State> getStats() {
        return stateRepository.findAll();
    }

    @Override
    public Optional<State> findState(Long id) {
        return stateRepository.findById(id);
    }

    @Override
    public void deleteState(Long id) {
        stateRepository.deleteById(id);
    }

    @Override
    public void editState(Long id, State state) {
        State stateEdit = this.findState(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        NullAwareBeanUtils.copyNonNullProperties(state,stateEdit);

        stateRepository.save(stateEdit);
    }
}

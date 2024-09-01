package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.State;

import java.util.List;
import java.util.Optional;

public interface IStateService {
    public void saveState(State state);
    public List<State> getStates();
    public Optional<State> findState(Long id);
    public void deleteState(Long id);
    public void editState(Long id, State state);
}

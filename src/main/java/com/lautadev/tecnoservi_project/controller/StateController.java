package com.lautadev.tecnoservi_project.controller;

import com.lautadev.tecnoservi_project.model.State;
import com.lautadev.tecnoservi_project.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private IStateService stateService;

    @PostMapping("/save")
    public ResponseEntity<String> saveState(@RequestBody State state){
        stateService.saveState(state);
        return ResponseEntity.ok("State created successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<List<State>> getStates(){
        return ResponseEntity.ok(stateService.getStates());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteState(@PathVariable Long id){
        stateService.deleteState(id);
        return ResponseEntity.ok("state deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<String> editState(@PathVariable Long id, @RequestBody State state){
        stateService.editState(id,state);
        return ResponseEntity.ok("State edited");
    }
}

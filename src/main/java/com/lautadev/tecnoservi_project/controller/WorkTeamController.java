package com.lautadev.tecnoservi_project.controller;

import com.lautadev.tecnoservi_project.model.WorkTeam;
import com.lautadev.tecnoservi_project.service.IWorkTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/work-team")
public class WorkTeamController {
    @Autowired
    private IWorkTeamService workTeamService;

    @PostMapping("/save")
    public ResponseEntity<String> saveWorkTeam(@RequestBody WorkTeam workTeam){
        workTeamService.saveWorkTeam(workTeam);
        return ResponseEntity.ok("Work Team saved");
    }

    @GetMapping("/get")
    public ResponseEntity<List<WorkTeam>> getWorkTeams(){
        return ResponseEntity.ok(workTeamService.getWorkTeams());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<WorkTeam> findWorkTeam(@PathVariable Long id){
        Optional<WorkTeam> workTeam = workTeamService.findWorkTeam(id);
        return workTeam.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWorkTeam(@PathVariable Long id){
        workTeamService.deleteWorkTeam(id);
        return ResponseEntity.ok("Work team deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<String> editWorkTeam(@PathVariable Long id, @RequestBody WorkTeam workTeam){
        workTeamService.editWorkTeam(id,workTeam);
        return ResponseEntity.ok("Work team edited");
    }
}

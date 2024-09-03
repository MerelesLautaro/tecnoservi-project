package com.lautadev.tecnoservi_project.controller;

import com.lautadev.tecnoservi_project.dto.EmployedDTO;
import com.lautadev.tecnoservi_project.model.Employed;
import com.lautadev.tecnoservi_project.service.IEmployedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employed")
public class EmployedController {
    @Autowired
    private IEmployedService employedService;

    @PostMapping("/save")
    public ResponseEntity<String> saveEmployed(@RequestBody Employed employed){
        employedService.saveEmployed(employed);
        return ResponseEntity.ok("Employed saved successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<List<EmployedDTO>> getEmployees(){
        return ResponseEntity.ok(employedService.getEmployees());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployedDTO> findEmployed(@PathVariable Long id){
        Optional<EmployedDTO> employedDTO =  employedService.findEmployed(id);
        return employedDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployed(@PathVariable Long id){
        employedService.deleteEmployed(id);
        return ResponseEntity.ok("Employed deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<String> editEmployed(@PathVariable Long id, @RequestBody Employed employed){
        employedService.editEmployed(id,employed);
        return ResponseEntity.ok("Employed edited");
    }
}

package com.lautadev.tecnoservi_project.controller;

import com.lautadev.tecnoservi_project.model.Client;
import com.lautadev.tecnoservi_project.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClienteService clientService;

    @PostMapping("/save")
    public ResponseEntity<String> saveClient(@RequestBody Client client){
        clientService.saveClient(client);
        return ResponseEntity.ok("Client saved successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<List<Client>> getClients(){
        return ResponseEntity.ok(clientService.getClients());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Client> findClient(@PathVariable Long id){
        Optional<Client> client = clientService.findClient(id);
        return client.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok("Client deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<String> editClient(@PathVariable Long id, @RequestBody Client client){
        clientService.editClient(id,client);
        return ResponseEntity.ok("Client edited");
    }
}

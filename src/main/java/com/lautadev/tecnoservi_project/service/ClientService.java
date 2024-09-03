package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.dto.ClientDTO;
import com.lautadev.tecnoservi_project.model.Client;
import com.lautadev.tecnoservi_project.repository.IClientRepository;
import com.lautadev.tecnoservi_project.throwable.EntityNotFoundException;
import com.lautadev.tecnoservi_project.util.NullAwareBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClienteService {
    @Autowired
    private IClientRepository clientRepository;

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<ClientDTO> getClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOS = new ArrayList<>();

        for(Client client:clients){
            clientDTOS.add(ClientDTO.fromClient(client));
        }

        return clientDTOS;
    }

    @Override
    public Optional<ClientDTO> findClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));
        return Optional.ofNullable(ClientDTO.fromClient(client));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void editClient(Long id, Client client) {
        Client clientEdit = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));

        NullAwareBeanUtils.copyNonNullProperties(client,clientEdit);

        clientRepository.save(clientEdit);
    }
}

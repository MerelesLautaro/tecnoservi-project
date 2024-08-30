package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public void saveClient(Client client);
    public List<Client> getClients();
    public Optional<Client> findClient(Long id);
    public void deleteClient(Long id);
    public void editClient(Long id,Client client);
}

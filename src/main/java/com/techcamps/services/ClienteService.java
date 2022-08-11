package com.techcamps.services;

import com.techcamps.controllers.contracts.IClienteService;
import com.techcamps.entities.Cliente;
import com.techcamps.services.contracts.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    public List<Cliente> listClientes() {
        return clienteRepository.findAll();
    }
}

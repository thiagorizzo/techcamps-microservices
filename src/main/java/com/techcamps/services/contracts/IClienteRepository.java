package com.techcamps.services.contracts;

import com.techcamps.entities.Cliente;

import java.util.List;

public interface IClienteRepository {
    List<Cliente> findAll();
}

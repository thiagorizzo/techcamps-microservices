package com.techcamps.controllers.contracts;

import com.techcamps.entities.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> listClientes();
}

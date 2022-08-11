package com.techcamps.repositories;

import com.techcamps.entities.Cliente;
import com.techcamps.services.contracts.IClienteRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ClienteRepository implements IClienteRepository {

    @Override
    public List<Cliente> findAll() {
        return List.of(
          new Cliente(1, "Thiago Rizzo"),
          new Cliente(2, "Pedro Batista")
        );
    }
}

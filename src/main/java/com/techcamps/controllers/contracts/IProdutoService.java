package com.techcamps.controllers.contracts;

import com.techcamps.entities.Produto;

import java.util.List;
import java.util.Optional;

public interface IProdutoService {
    List<Produto> listProdutos();

    Optional<Produto> getByCodigo(int codigo);

    List<Produto> listByNome(String nome);

    Produto create(Produto produto);

    void remove(Produto produto);

    Produto update(Produto produto);
}

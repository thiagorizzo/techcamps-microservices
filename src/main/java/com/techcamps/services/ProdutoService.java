package com.techcamps.services;

import com.techcamps.controllers.contracts.IProdutoService;
import com.techcamps.repositories.IProdutoRepository;
import com.techcamps.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Override
    public List<Produto> listProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> getByCodigo(int codigo) {
        return produtoRepository.findById(codigo);
    }

    @Override
    public List<Produto> listByNome(String nome) {
        List<Produto> produtos = produtoRepository.listByNome(nome);
        return produtos;
    }

    @Override
    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void remove(Produto produto) {
        produtoRepository.delete(produto);
    }

    @Override
    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }
}

package com.techcamps.controllers;

import com.techcamps.controllers.contracts.IProdutoService;
import com.techcamps.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    public IProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listProdutos() throws IOException {
        try {
            List<Produto> produtos = produtoService.listProdutos();
            return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity("Ocorreu um erro: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) throws IOException {
        try {
            Produto novoProduto = produtoService.create(produto);
            return new ResponseEntity<Produto>(novoProduto, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity("Ocorreu um erro: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) throws IOException {
        try {
            Produto produtoAtualizado = produtoService.update(produto);
            return new ResponseEntity<Produto>(produtoAtualizado, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity("Ocorreu um erro: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity deleteProduto(@RequestBody Produto produto) throws IOException {
        try {
            produtoService.remove(produto);
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity("Ocorreu um erro: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<Produto>> getProduto(@PathVariable("codigo") int codigo) {
        Optional<Produto> produto = produtoService.getByCodigo(codigo);
        return new ResponseEntity<Optional<Produto>>(produto, HttpStatus.OK);
    }

    // http://localhost/produto/mouse/nome  -> @GetMapping(path = "{nome}/nome")
    // http://localhost/produto/nome/mouse -> @GetMapping(path = "nome/{nome}")

    @GetMapping(path = "{nome}/nome")
    public ResponseEntity<List<Produto>> listByNome(@PathVariable("nome") String nome) throws IOException {
        try {
            List<Produto> produtos = produtoService.listByNome(nome);
            return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity("Ocorreu um erro: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

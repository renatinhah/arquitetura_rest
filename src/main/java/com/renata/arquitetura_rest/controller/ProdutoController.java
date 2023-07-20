package com.renata.arquitetura_rest.controller;

import com.renata.arquitetura_rest.entity.Produto;
import com.renata.arquitetura_rest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws Exception {
        return ResponseEntity.ok().body(service.save(produto));
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value="/busca-produtos")
    public ResponseEntity<List<Produto>> buscaTodosProdutos() {
        return ResponseEntity.ok().body(service.findAll());
    }
}

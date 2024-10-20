package com.lucasangelo.todosimple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lucasangelo.todosimple.models.Produto;
import com.lucasangelo.todosimple.services.ProdutoService;

import java.util.List;
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
@Autowired
private ProdutoService produtoService;
@GetMapping
public List<Produto> listarProdutos() {
return produtoService.listarProdutos();
}
@PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
        return ResponseEntity.ok(produtoAtualizado);
    }
@PostMapping
public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
Produto novoProduto = produtoService.salvarProduto(produto);
return ResponseEntity.ok(novoProduto);
}
@GetMapping("/{id}")
public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) {
Produto produto = produtoService.buscarProdutoPorId(id);
return ResponseEntity.ok(produto);
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
produtoService.deletarProduto(id);
return ResponseEntity.noContent().build();
}
}
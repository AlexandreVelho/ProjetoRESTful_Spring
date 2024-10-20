package com.lucasangelo.todosimple.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasangelo.todosimple.models.Produto;
import com.lucasangelo.todosimple.repositories.ProdutoRepository;

import java.util.List;
@Service
public class ProdutoService {
@Autowired
private ProdutoRepository produtoRepository;
public List<Produto> listarProdutos() {
return produtoRepository.findAll();
}
public Produto salvarProduto(Produto produto) {
return produtoRepository.save(produto);
}
public Produto buscarProdutoPorId(Long id) {
return produtoRepository.findById(id).orElse(null);
}
public void deletarProduto(Long id) {
produtoRepository.deleteById(id);
}
}
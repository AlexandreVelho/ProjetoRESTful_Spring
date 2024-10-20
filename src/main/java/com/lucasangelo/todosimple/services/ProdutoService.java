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
public Produto atualizarProduto(Long id, Produto produto) {
    // Lógica para buscar o produto pelo ID
    Produto produtoExistente = buscarProdutoPorId(id);

    // Verifica se o produto existe
    if (produtoExistente == null) {
        // Você pode lançar uma exceção ou lidar de outra forma
        return null; // Ou lançar uma exceção personalizada
    }

    // Aplicar as atualizações
    produtoExistente.setNome(produto.getNome());
    produtoExistente.setPreco(produto.getPreco());
    produtoExistente.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque());
    
    // Atualizar o tipo do produto (caso necessário)
    // Verifique se o tipo do produto está sendo atualizado no JSON
    if (produto.getTipo() != null) {
        // Aqui você pode adicionar lógica para lidar com o tipo específico, 
        // mas geralmente é mais seguro apenas manter o tipo existente se não for necessário alterá-lo
        // produtoExistente.setTipoProduto(produto.getTipoProduto());
    }

    // Salve o produto atualizado
    return produtoRepository.save(produtoExistente); // Salva as alterações no banco de dados
}

}
package com.lucasangelo.todosimple.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Herança em uma única tabela
@DiscriminatorColumn(name = "tipo_produto")
public abstract class Produto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nome;
private double preco;
private int quantidadeEmEstoque;
public abstract String getTipo(); // Método abstrato para obter tipo do produto
}
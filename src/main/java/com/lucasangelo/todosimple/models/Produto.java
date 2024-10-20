package com.lucasangelo.todosimple.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Herança em uma única tabela
@DiscriminatorColumn(name = "tipo_produto")
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, 
    include = JsonTypeInfo.As.PROPERTY, 
    property = "tipo_produto" // Nome da propriedade que será usada para diferenciar os tipos
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ProdutoPerecivel.class, name = "perecivel"),
    @JsonSubTypes.Type(value = ProdutoNaoPerecivel.class, name = "nao_perecivel"),
    @JsonSubTypes.Type(value = ProdutoEmPromocao.class, name = "promocao")
})
public abstract class Produto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nome;
private double preco;
private int quantidadeEmEstoque;
public abstract String getTipo(); // Método abstrato para obter tipo do produto
}
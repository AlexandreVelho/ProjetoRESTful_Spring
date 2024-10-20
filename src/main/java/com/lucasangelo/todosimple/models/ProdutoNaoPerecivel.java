package com.lucasangelo.todosimple.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("NAOPERECIVEL")
public class ProdutoNaoPerecivel extends Produto {
private String durabilidade; // Tempo de durabilidade
@Override
public String getTipo() {
return "Não Perecível";
}
}
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
@DiscriminatorValue("PERECIVEL")
public class ProdutoPerecivel extends Produto {
private String dataValidade;
@Override
public String getTipo() {
return "Perecível";
}
}
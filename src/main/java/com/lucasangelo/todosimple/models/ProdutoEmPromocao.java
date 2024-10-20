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
@DiscriminatorValue("PROMOCAO")
public class ProdutoEmPromocao extends Produto {
private double precoPromocional;
@Override
public String getTipo() {
return "Em Promoção";
}
}
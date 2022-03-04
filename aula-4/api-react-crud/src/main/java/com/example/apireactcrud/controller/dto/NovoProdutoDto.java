package com.example.apireactcrud.controller.dto;

import com.example.apireactcrud.model.Produto;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class NovoProdutoDto {
    @NotBlank
    private String nome;
    @NotBlank
    private Double valor;
    @NotBlank
    private String descricao;

    public Produto converter(){
        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produto.setNome(nome);
        produto.setValor(valor);
        produto.setData(LocalDate.now());
        return produto;
    }
}

package com.example.mvcproject.controller.dto;

import com.example.mvcproject.model.Pedido;

import javax.validation.constraints.NotBlank;

public class NovoPedidoDto {
    @NotBlank
    private String nome;

    @NotBlank
    private String urlProduto;

    @NotBlank
    private String urlImagemProduto;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagemProduto() {
        return urlImagemProduto;
    }

    public void setUrlImagemProduto(String urlImagemProduto) {
        this.urlImagemProduto = urlImagemProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido converter(){
        Pedido pedido = new Pedido();
        pedido.setNome(this.nome);
        pedido.setDescricao(this.descricao);
        pedido.setUrlProduto(this.urlProduto);
        pedido.setUrlImagemProduto(this.urlImagemProduto);
        return pedido;
    }
}

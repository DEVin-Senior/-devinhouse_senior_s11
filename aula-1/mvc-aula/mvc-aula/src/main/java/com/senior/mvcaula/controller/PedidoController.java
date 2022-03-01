package com.senior.mvcaula.controller;

import com.senior.mvcaula.model.Pedido;
import com.senior.mvcaula.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service){
        this.service = service;
    }

    @GetMapping("/todos")
    public String listaPedidos(Model model){
        Pedido pedido1 = new Pedido();
        pedido1.setDescricao("AAAAA");
        pedido1.setNome("AA");
        pedido1.setId(1L);

        service.adicionaPedido(pedido1);
        pedido1.setId(2L);

        service.adicionaPedido(pedido1);
        pedido1.setId(3L);

        service.adicionaPedido(pedido1);

        List<Pedido> pedidos = service.listaPedido();
        model.addAllAttributes(pedidos);
        return "pedido";
    }
}

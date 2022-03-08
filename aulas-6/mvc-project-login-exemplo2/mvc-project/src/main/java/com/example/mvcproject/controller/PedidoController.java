package com.example.mvcproject.controller;

import com.example.mvcproject.controller.dto.NovoPedidoDto;
import com.example.mvcproject.model.Pedido;
import com.example.mvcproject.repository.PedidoRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    private final PedidoRepository repository;

    public PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String pedido(Model model){
        List<Pedido> pedidos = repository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "pedido";

    }

    @GetMapping("formulario")
    public String formulario(NovoPedidoDto pedidoDto){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novoPedido(@Valid NovoPedidoDto pedidoDto, BindingResult result){
        if (result.hasErrors())
            return "pedido/formulario";

        repository.save(pedidoDto.converter());
        System.out.println(pedidoDto);

        return "redirect:/pedido";
    }


}

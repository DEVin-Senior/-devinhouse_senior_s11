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
       /* Pedido pedido = new Pedido();
        pedido.setNome("Fire TV Stick");
        pedido.setUrlProduto("https://www.amazon.com.br/dp/B08C1K6LB2/?_encoding=UTF8&ref_=mapping_firetv&pf_rd_r=4AHQ8YBKAESE4YMM89KB&pf_rd_p=de0cb307-01e1-44f5-aaa7-7a74eabc59c4&pd_rd_r=ae91f56c-9150-4b89-9614-7a1d2073cff5&pd_rd_w=HoC9w&pd_rd_wg=gbHVI");
        pedido.setUrlImagemProduto("https://images-na.ssl-images-amazon.com/images/G/32/apparel/rcxgs/tile._CB483369971_.gif");
        pedido.setDescricao("Fire TV com Alexa: aproveite streaming rápido e em Full HD. Inclui Controle Remoto por Voz com Alexa, com botões de ligar e desligar e volume.");

        repository.save(pedido);
        repository.save(pedido);
        repository.save(pedido);*/
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

        return "pedido/formulario";
    }


}

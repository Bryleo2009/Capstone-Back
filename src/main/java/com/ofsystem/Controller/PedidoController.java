package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Pedido;
import com.ofsystem.Service.Imple.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return new ResponseEntity<List<Pedido>>(service.listar(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> listarPorId(@PathVariable("id") Integer id) {
        Pedido unaPedido = service.listarxID(id);
        if(unaPedido == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        return new ResponseEntity<Pedido>(unaPedido,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar( @RequestBody Pedido dato) {
        Pedido unaPedido = service.listarxID(dato.getIdPedido());
        URI location = null;
        if(unaPedido != null) {
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaPedido.getIdPedido()).toUri();
            throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdPedido() + " --- " + location);
        } else {
            service.registrar(dato);
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdPedido()).toUri();
        }

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Pedido> modificar( @RequestBody Pedido dato) {
        return new ResponseEntity<Pedido>(service.modificar(dato),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        Pedido unaPedido = service.listarxID(id);
        if(unaPedido == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        } else {
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}

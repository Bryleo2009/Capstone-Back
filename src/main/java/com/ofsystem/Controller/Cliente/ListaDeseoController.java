package com.ofsystem.Controller.Cliente;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Cliente.ListaDeseos;
import com.ofsystem.Service.Imple.Cliente.ListaDeseoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/ListaDeseos")
public class ListaDeseoController {

    @Autowired
    private ListaDeseoServiceImpl service;

    @GetMapping
    public ResponseEntity<List<ListaDeseos>> listar() {
        return new ResponseEntity<List<ListaDeseos>>(service.listar(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaDeseos> listarPorId(@PathVariable("id") Integer id) {
        ListaDeseos unaCarrito = service.listarxID(id);
        if(unaCarrito == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        return new ResponseEntity<ListaDeseos>(unaCarrito,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar( @RequestBody ListaDeseos dato) {
        ListaDeseos unaCarrito = service.listarxID(dato.getIdListaDeseo());
        URI location = null;
        if(unaCarrito != null) {
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaCarrito.getIdListaDeseo()).toUri();
            throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdListaDeseo() + " --- " + location);
        } else {
            service.registrar(dato);
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdListaDeseo()).toUri();
        }

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<ListaDeseos> modificar( @RequestBody ListaDeseos dato) {
        return new ResponseEntity<ListaDeseos>(service.modificar(dato),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        ListaDeseos unaCarrito = service.listarxID(id);
        if(unaCarrito == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        } else {
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}

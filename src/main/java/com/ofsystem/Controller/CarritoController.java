package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Carrito;
import com.ofsystem.Service.Imple.CarritoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Carritos")
public class CarritoController {

    @Autowired
    private CarritoServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Carrito>> listar() {
        return new ResponseEntity<List<Carrito>>(service.listar(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> listarPorId(@PathVariable("id") Integer id) {
        Carrito unaCarrito = service.listarxID(id);
        if(unaCarrito == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        return new ResponseEntity<Carrito>(unaCarrito,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar( @RequestBody Carrito dato) {
        Carrito unaCarrito = service.listarxID(dato.getIdCarrito());
        URI location = null;
        if(unaCarrito != null) {
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaCarrito.getIdCarrito()).toUri();
            throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdCarrito() + " --- " + location);
        } else {
            service.registrar(dato);
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdCarrito()).toUri();
        }

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Carrito> modificar( @RequestBody Carrito dato) {
        return new ResponseEntity<Carrito>(service.modificar(dato),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        Carrito unaCarrito = service.listarxID(id);
        if(unaCarrito == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        } else {
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}

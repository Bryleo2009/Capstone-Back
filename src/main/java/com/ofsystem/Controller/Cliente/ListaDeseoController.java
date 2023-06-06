package com.ofsystem.Controller.Cliente;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.*;
import com.ofsystem.Model.Cliente.ListaDeseos;
import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Model.Cliente.TrazabilidadPedidos;
import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Model.Usuario.Usuario;
import com.ofsystem.Service.Imple.Cliente.ListaDeseoServiceImpl;
import com.ofsystem.Service.Imple.Cliente.TrazabilidadPedidosServiceImpl;
import com.ofsystem.Service.Imple.Comprobante.ComprobanteServiceImpl;
import com.ofsystem.Service.Imple.Comprobante.DetalleServiceImpl;
import com.ofsystem.Service.Imple.Enums.EstPedidoServiceImpl;
import com.ofsystem.Service.Imple.Enums.RolServiceImpl;
import com.ofsystem.Service.Imple.Producto.ProductoServiceImpl;
import com.ofsystem.Service.Imple.Usuario.ClienteServiceImpl;
import com.ofsystem.Service.Imple.Usuario.TrabajadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Enums.Color;
import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Producto.ProductoTallaColor;
import com.ofsystem.Model.Enums.Talla;
import com.ofsystem.Service.Imple.Enums.ColorServiceImpl;
import com.ofsystem.Service.Imple.Producto.ProductoServiceImpl;
import com.ofsystem.Service.Imple.Producto.ProductoTallaColorServiceImpl;
import com.ofsystem.Service.Imple.Enums.TallaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/ListaDeseos")
public class ListaDeseoController {

    @Autowired
    private ListaDeseoServiceImpl service;
    @Autowired
    private ClienteServiceImpl serviceCli;
    @Autowired
    private ProductoServiceImpl servicePro;

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

    /*@PostMapping
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
    }*/





    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody ListaDeseos dato) {

        System.out.println("dato ListadeseoControler: " + dato);
        ListaDeseos unaListaDeseos = service.listarxID(dato.getIdListaDeseo());
        if (unaListaDeseos != null) {
            throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdListaDeseo());
        } else {
            Producto producto = new Producto();
            ListaDeseos nuevaListaDeseos = new ListaDeseos();
            nuevaListaDeseos.setFechaListaDeseo(new Date());
            Cliente cliente = serviceCli.listarxID(dato.getId().getId());
            nuevaListaDeseos.setId(cliente);
            service.registrar(nuevaListaDeseos);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nuevaListaDeseos.getIdListaDeseo()).toUri();
            return ResponseEntity.created(location).build();
        }

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

    @GetMapping("/listadeseo/{id_lista_deseo}")
    public ResponseEntity<List<ListadeseoFilter>> listarListadeseos(@PathVariable("id_lista_deseo") int id_lista_deseo) {
        List<ListadeseoFilter> unaLista = service.listarListadeseos(id_lista_deseo);
        System.out.println(unaLista);
        if(unaLista == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id_lista_deseo);
        }
        return new ResponseEntity<List<ListadeseoFilter>>(unaLista,HttpStatus.OK);
    }
}

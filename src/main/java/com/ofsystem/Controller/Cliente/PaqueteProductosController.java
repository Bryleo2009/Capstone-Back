package com.ofsystem.Controller.Cliente;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.CarritoFilter;
import com.ofsystem.Mapper.Filter.PaqueteFilter;
import com.ofsystem.Model.Cliente.PaqueteProductos;
import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Service.Imple.Cliente.PaqueteProductosServiceImpl;
import com.ofsystem.Service.Imple.Producto.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/PaqueteProductos")
public class PaqueteProductosController {

    @Autowired
    private PaqueteProductosServiceImpl service;
    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping
    public ResponseEntity<List<PaqueteProductos>> listar() {
        return new ResponseEntity<List<PaqueteProductos>>(service.listar(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaqueteProductos> listarPorId(@PathVariable("id") Integer id) {
        PaqueteProductos unaCarrito = service.listarxID(id);
        if(unaCarrito == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        return new ResponseEntity<PaqueteProductos>(unaCarrito,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar( @RequestBody PaqueteFilter dato) {
        System.out.println("dato PaqueteControler: " + dato);
        PaqueteProductos paqueteProductos = new PaqueteProductos();
        try {
            for (CarritoFilter carritoFilter: dato.getPaqueteProductos()){
                paqueteProductos.setId(service.idPedido() + 1);
                paqueteProductos.setProducto_id_product(productoService.listarxID(carritoFilter.getIdProduct()));
                paqueteProductos.setCantProduct(carritoFilter.getCantProduct());
                paqueteProductos.setFechaPedidoProduc(new Date());
                paqueteProductos.setIdCliente(dato.getCliente());
                service.registrar(paqueteProductos);
                System.out.println(paqueteProductos);
            }
            System.out.println("Paquete creado");
        } catch (Exception e) {
            System.out.println("Comprobante no creado" + e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PaqueteProductos> modificar(@RequestBody PaqueteProductos dato) {
        return new ResponseEntity<PaqueteProductos>(service.modificar(dato),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        PaqueteProductos unaCarrito = service.listarxID(id);
        if(unaCarrito == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        } else {
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}

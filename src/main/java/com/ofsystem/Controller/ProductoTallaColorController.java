package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.CarritoFilter;
import com.ofsystem.Model.Color;
import com.ofsystem.Model.Producto;
import com.ofsystem.Model.ProductoTallaColor;
import com.ofsystem.Model.Talla;
import com.ofsystem.Service.Imple.ColorServiceImpl;
import com.ofsystem.Service.Imple.ProductoServiceImpl;
import com.ofsystem.Service.Imple.ProductoTallaColorServiceImpl;
import com.ofsystem.Service.Imple.TallaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/ProductoTallaColor")
public class ProductoTallaColorController {

    @Autowired
    private ProductoTallaColorServiceImpl service;

    @Autowired
    private ProductoServiceImpl serviceProduct;
    @Autowired
    private TallaServiceImpl serviceTalla;
    @Autowired
    private ColorServiceImpl serviceColor;
    @GetMapping
    public ResponseEntity<List<ProductoTallaColor>> listar() {
        return new ResponseEntity<List<ProductoTallaColor>>(service.listar(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoTallaColor> listarPorId(@PathVariable("id") Integer id) {
        ProductoTallaColor unaProductoTallaColor = service.listarxID(id);
        if(unaProductoTallaColor == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }
        return new ResponseEntity<ProductoTallaColor>(unaProductoTallaColor,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar( @RequestBody ProductoTallaColor dato) {
        ProductoTallaColor unaProductoTallaColor = service.listarxID(dato.getIdProductoTallaColor());
        URI location = null;
        if(unaProductoTallaColor != null) {
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaProductoTallaColor.getIdProductoTallaColor()).toUri();
            throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdProductoTallaColor() + " --- " + location);
        } else {
            service.registrar(dato);
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdProductoTallaColor()).toUri();
        }

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<ProductoTallaColor> modificar( @RequestBody ProductoTallaColor dato) {

        return new ResponseEntity<ProductoTallaColor>(service.modificar(dato),HttpStatus.OK);

    }

    @PutMapping("/carrito")
    public ResponseEntity<Object> CarritoOperador( @RequestBody List<CarritoFilter> dato) {


        for (CarritoFilter carritoFilter : dato) {

            int idProduct = carritoFilter.getIdProduct();
            int cantidad = carritoFilter.getCantProduct();
            int talla = carritoFilter.getTallaid();
            int color = carritoFilter.getColorid();

            Producto unproducto = serviceProduct.listarxID(idProduct);
            System.out.println(unproducto);
            Talla unatalla = serviceTalla.listarxID(talla);
            System.out.println(unatalla);
            Color uncolor = serviceColor.listarxID(color);
            System.out.println(uncolor);

            ProductoTallaColor productoTallaColor = service.findByProductoAndTallaAndColor(unproducto,unatalla,uncolor);

            if (productoTallaColor != null) {
                if (productoTallaColor.getStockVirtualProduct() >= cantidad && (productoTallaColor.getTalla().getIdTalla()==talla) && (productoTallaColor.getColor().getIdColor()==color)) {
                    productoTallaColor.setStockVirtualProduct(productoTallaColor.getStockVirtualProduct() - cantidad);
                    productoTallaColor.setIdProductoTallaColor(productoTallaColor.getIdProductoTallaColor());
                    System.out.println("disminuio");
                    service.modificar(productoTallaColor);
                }
            }
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
        ProductoTallaColor unaProductoTallaColor = service.listarxID(id);
        if(unaProductoTallaColor == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        } else {
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}

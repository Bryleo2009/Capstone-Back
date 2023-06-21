package com.ofsystem.Controller.Cliente;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.ListadeseoFilter;
import com.ofsystem.Mapper.Filter.PedidoFilter;
import com.ofsystem.Mapper.Filter.SeguimientoListadeseosFilter;
import com.ofsystem.Mapper.Filter.SeguimientoPedidoFilter;
import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Model.Cliente.TrazabilidadPedidos;
/*
import com.ofsystem.Service.Imple.Cliente.ListaDeseoServiceImpl;*/
import com.ofsystem.Service.Imple.Cliente.TrazabilidadPedidosServiceImpl;
import com.ofsystem.Service.Imple.Comprobante.ComprobanteServiceImpl;
import com.ofsystem.Service.Imple.Comprobante.DetalleServiceImpl;
import com.ofsystem.Service.Imple.Enums.EstPedidoServiceImpl;
import com.ofsystem.Service.Imple.Enums.RolServiceImpl;
import com.ofsystem.Service.Imple.Usuario.TrabajadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
/*

@RestController
@RequestMapping("/ListaDeseos")
public class ListaDeseoController {

    @Autowired
    private ListaDeseoServiceImpl service;*/
   /* @Autowired
    private DetalleServiceImpl detalleService;
    @Autowired
    private ComprobanteServiceImpl comprobanteService;
    @Autowired
    private EstPedidoServiceImpl estPedidoService;
    @Autowired
    private TrabajadorServiceImpl trabajadorService;
    @Autowired
    private RolServiceImpl rolService;
    @Autowired
    private TrazabilidadPedidosServiceImpl trazabilidadPedidosService;

  /*  @GetMapping
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
   /* @PostMapping
    public ResponseEntity<Object> registrar( @RequestBody ListadeseoFilter dato,
                                             @RequestParam("iuc") String iuc) {
        System.out.println("dato ListadeseoControler: " + dato);
        System.out.println("iuc: " + iuc);
        ListaDeseos listadeseo = new ListaDeseos();
        TrazabilidadPedidos trazabilidadPedidos = new TrazabilidadPedidos();
        try {
            //listadeseo
            listadeseo.setFechaListaDeseo(new Date());
            listadeseo.setObservacionesListaDeseo("Online");
            listadeseo.setCantidadTotalListaDeseo(listadeseo.cantidadTotal(detalleService.findByIdComp_Iuc(iuc)));
            listadeseo.setNombreRecojoListaDeseo(dato.getNombreRecojo());
            listadeseo.setApellidoRecojoListaDeseo(dato.getApellidoRecojo());
            listadeseo.setCelularRecojoListaDeseo(dato.getCelularRecojo());
            listadeseo.setCorreoRecojoListaDeseo(dato.getCorreoRecojo());
            listadeseo.setDireccionRecojoListaDeseo(dato.getDireccionRecojo());
            listadeseo.setIdComp(comprobanteService.findByIuc(iuc));
            listadeseo.setIdDetalle(detalleService.findByIdComp_Iuc(iuc));
            service.registrar(listadeseo);
            System.out.println("Pedido creado");
        } catch (Exception e) {
            System.out.println("Pedido no creado");
        }
        return new ResponseEntity<>(HttpStatus.OK);
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
    @GetMapping("/seguimiento/{idUser}")
    public ResponseEntity<List<SeguimientoListadeseosFilter>> listarListadeseo(@PathVariable("idUser")int idUser){
        return new ResponseEntity<>(service.listarListadeseo(idUser),HttpStatus.OK);
    }
}*/

package com.ofsystem.Controller.Cliente;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.PedidoFilter;
import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Model.Cliente.TrazabilidadPedidos;
import com.ofsystem.Model.Usuario.Trabajador;
import com.ofsystem.Model.Usuario.Usuario;
import com.ofsystem.Service.Imple.Cliente.PaqueteProductosServiceImpl;
import com.ofsystem.Service.Imple.Cliente.PedidoServiceImpl;
import com.ofsystem.Service.Imple.Cliente.TrazabilidadPedidosServiceImpl;
import com.ofsystem.Service.Imple.Comprobante.ComprobanteServiceImpl;
import com.ofsystem.Service.Imple.Enums.EstPedidoServiceImpl;
import com.ofsystem.Service.Imple.Enums.RolServiceImpl;
import com.ofsystem.Service.Imple.Usuario.ClienteServiceImpl;
import com.ofsystem.Service.Imple.Usuario.TrabajadorServiceImpl;
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
@RequestMapping("/Pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl service;
    @Autowired
    private PaqueteProductosServiceImpl paqueteProductosService;
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
    public ResponseEntity<Object> registrar( @RequestBody PedidoFilter dato,
                                             @RequestParam("iuc") String iuc) {
        System.out.println("dato PedidoControler: " + dato);
        System.out.println("iuc: " + iuc);
        //pedido
        Pedido pedido = new Pedido();
        pedido.setIdProduct(paqueteProductosService.findByIdClienteaAndAndFechaPedidoProduc(dato.getIdProduct().getCliente(), new Date()));
        pedido.setFechaCompra(new Date());
        pedido.setObservaciones("Online");
        /**
         * ! verificar la asigancion de cnatidad de compra
         */
        pedido.setCantidadCompra(pedido.cantidadTotal(paqueteProductosService.findByIdClienteaAndAndFechaPedidoProduc(dato.getIdProduct().getCliente(), new Date())));
        pedido.setNombreRecojo(dato.getNombreRecojo());
        pedido.setApellidoRecojo(dato.getApellidoRecojo());
        pedido.setCelularRecojo(dato.getCelularRecojo());
        pedido.setCorreoRecojo(dato.getCorreoRecojo());
        pedido.setDireccionRecojo(dato.getDireccionRecojo());
        pedido.setIdComp(comprobanteService.findByIuc(iuc));

        service.registrar(pedido);
        System.out.println("Pedido creado");
        //trazabilidad
        TrazabilidadPedidos trazabilidadPedidos = new TrazabilidadPedidos();
        trazabilidadPedidos.setIdPedido(service.findByIdComp_IdComp(pedido.getIdComp().getIdComp()));
        trazabilidadPedidos.setIdProceActual(estPedidoService.listarxID(1));
        trazabilidadPedidos.setFechaIniProc(new Date());
        trazabilidadPedidos.setObservac("Online");
        if(dato.getIdTraba().getNumDocumento()!= null){
            trazabilidadPedidos.setIdTraba(dato.getIdTraba());
        }else {
            trazabilidadPedidos.setIdTraba(trabajadorService.findByIdUserCliente_Username("Online"));
        }
        trazabilidadPedidosService.registrar(trazabilidadPedidos);
        System.out.println("Trazabilidad creado");
        return new ResponseEntity<>(HttpStatus.OK);
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

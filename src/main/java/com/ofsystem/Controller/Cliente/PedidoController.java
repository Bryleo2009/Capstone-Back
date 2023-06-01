package com.ofsystem.Controller.Cliente;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.PedidoFilter;
import com.ofsystem.Mapper.Filter.SeguimientoPedidoFilter;
import com.ofsystem.Mapper.Filter.TrazabilidadPedidoFilter;
import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Model.Cliente.TrazabilidadPedidos;
import com.ofsystem.Service.Imple.Cliente.PedidoServiceImpl;
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

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/Pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl service;
    @Autowired
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
        Pedido pedido = new Pedido();
        TrazabilidadPedidos trazabilidadPedidos = new TrazabilidadPedidos();
        try {
            //pedido
            pedido.setFechaPedido(new Date());
            pedido.setObservacionesPedido("Online");
            pedido.setCantidadTotalPedido(pedido.cantidadTotal(detalleService.findByIdComp_Iuc(iuc)));
            pedido.setNombreRecojoPedido(dato.getNombreRecojo());
            pedido.setApellidoRecojoPedido(dato.getApellidoRecojo());
            pedido.setCelularRecojoPedido(dato.getCelularRecojo());
            pedido.setCorreoRecojoPedido(dato.getCorreoRecojo());
            pedido.setDireccionRecojoPedido(dato.getDireccionRecojo());
            pedido.setIdComp(comprobanteService.findByIuc(iuc));
            pedido.setIdDetalle(detalleService.findByIdComp_Iuc(iuc));
            service.registrar(pedido);
            System.out.println("Pedido creado");
        } catch (Exception e) {
            System.out.println("Pedido no creado");
        }

        //trazabilidad
        try {
            trazabilidadPedidos.setIdPedido(service.findByIdComp_Iuc(iuc));
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
        } catch (Exception e) {
            System.out.println("Trazabilidad no creado");
        }
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

    @GetMapping("/seguimiento/{idUser}")
    public ResponseEntity<List<SeguimientoPedidoFilter>> listarPedido(@PathVariable("idUser")int idUser){
        List<SeguimientoPedidoFilter> seguimientoPedidoFilters = service.listarPedido(idUser);
        for (SeguimientoPedidoFilter seguimientoPedidoFilter : seguimientoPedidoFilters){
            seguimientoPedidoFilter.setTrazabilidad(service.TrazaPedido(seguimientoPedidoFilter.getId_pedido()));
        }


        return new ResponseEntity<>(seguimientoPedidoFilters,HttpStatus.OK);
    }




}

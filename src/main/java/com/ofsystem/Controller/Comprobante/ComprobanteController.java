package com.ofsystem.Controller.Comprobante;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.CarritoFilter;
import com.ofsystem.Mapper.Filter.ComprobanteFilter;
import com.ofsystem.Model.Comprobante.Comprobante;
import com.ofsystem.Model.Comprobante.Detalle;
import com.ofsystem.Model.Comprobante.TrazabilidadComprobantes;
import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Usuario.Trabajador;
import com.ofsystem.Model.Usuario.Usuario;
import com.ofsystem.Service.Imple.Comprobante.ComprobanteServiceImpl;
import com.ofsystem.Service.Imple.Comprobante.DetalleServiceImpl;
import com.ofsystem.Service.Imple.Comprobante.TrazabilidadComprobantesServiceImpl;
import com.ofsystem.Service.Imple.Enums.EstComproServiceImpl;
import com.ofsystem.Service.Imple.Enums.RolServiceImpl;
import com.ofsystem.Service.Imple.Enums.TipoComproServiceImpl;
import com.ofsystem.Service.Imple.Enums.TipoPagoServiceImpl;
import com.ofsystem.Service.Imple.Producto.ProductoServiceImpl;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/Comprobantes")
public class ComprobanteController {

	@Autowired
	private ComprobanteServiceImpl service;

	@Autowired
	private TipoComproServiceImpl tipoComproService;

	@Autowired
	private TipoPagoServiceImpl tipoPagoService;
	@Autowired
	private TrabajadorServiceImpl trabajadorService;

	@Autowired
	private DetalleServiceImpl detalleService;
	@Autowired
	private EstComproServiceImpl estComproService;
	@Autowired
	private ProductoServiceImpl productoService;

	@Autowired
	private TrazabilidadComprobantesServiceImpl trazabilidadComprobantesService;

	@Autowired
	private RolServiceImpl rolService;
	@GetMapping
	public ResponseEntity<List<Comprobante>> listar() {
		return new ResponseEntity<List<Comprobante>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Comprobante> listarPorId(@PathVariable("id") String id) {
		Comprobante unaComprobante = service.listarxID(id);
		if(unaComprobante == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Comprobante>(unaComprobante,HttpStatus.OK);
	}


	private String generarSiguienteIdComp(String lastIdComp) {
		int lastNumber = Integer.parseInt(lastIdComp.substring(1)); // Extraer el número sin el prefijo 'N'
		int nextNumber = lastNumber + 1;
		return String.format("N%04d", nextNumber);
	}

	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody ComprobanteFilter dato) {
		System.out.println("dato ComproControler: " + dato);
		String lastIdComp = service.findLastIdComp();
		System.out.println("anterior " + service.findLastIdComp());
		String nextIdComp = generarSiguienteIdComp(lastIdComp);
		System.out.println("nuevo " + nextIdComp);
		Comprobante comprobantes = new Comprobante();
		Detalle detalle = new Detalle();
		TrazabilidadComprobantes trazabilidadComprob = new TrazabilidadComprobantes();

		try {
			//comprobante

			comprobantes.setIdComp(nextIdComp);
			comprobantes.setMontoSubtotalComp(dato.getMontoProducto());
			comprobantes.setMontoTotalComp(dato.getAmmount());
			comprobantes.setFechaEmiComp(new Date());
			comprobantes.setDireccionComp(dato.getDireccionComp());
			comprobantes.setUbigeoComp(dato.getUbigeoComp());
			comprobantes.setIdTp(tipoPagoService.listarxID(1));
			if(dato.isIdTc()){ //true = factura
				comprobantes.setIdTc(tipoComproService.listarxID(2));
				comprobantes.setRuc(dato.getRuc());
				comprobantes.setRazonSocial(dato.getRazonSocial());
			}else {
				comprobantes.setIdTc(tipoComproService.listarxID(1));
			}
			comprobantes.setIdCliente(dato.getCliente());
			comprobantes.setIuc();
			service.registrar(comprobantes);
			System.out.println("Comprobante creado");
		}catch (Exception e) {
			System.out.println("Comprobante no creado " + e);
		}

		try {
			//detalle

			detalle.setIdComp(service.listarxID(nextIdComp));
			for (CarritoFilter carritoFilter : dato.getCarritoFilterList()){
				int cantidad = carritoFilter.getCantProduct();
				detalle.setIdDcomp(detalleService.idDetalle() + 1);
				detalle.setCantProductDetalle(cantidad);
				Producto producto = productoService.listarxID(carritoFilter.getIdProduct());
				System.out.println(producto.getIUP());
				detalle.setPrecioUniDetalle(producto.getPrecioUni());
				detalle.setPrecioTotalDetalle(producto.getPrecioUni() * cantidad);
				detalle.setProductoDetalle(producto.getNombreProduct());
				detalle.setIupProduct(producto.getIUP());
				detalle.setImagen(producto.getImagen());
				detalle.setPrecioDescuento(producto.getPrecioDescuProduct());
				/**
				 * ! esta reemplazando uno sobre el otro
				 */
				detalleService.registrar(detalle);
				System.out.println(detalle);
			}
			System.out.println("Detalle creado");
		}catch (Exception e) {
			System.out.println("Detalle no creado" + e);
		}

		try {
			//trazabilidad
			trazabilidadComprob.setIdComp(service.listarxID(nextIdComp));
			trazabilidadComprob.setIdProceActual(estComproService.listarxID(1));
			trazabilidadComprob.setFechaIniProc(new Date());
			trazabilidadComprob.setObservac("Online");
			if(dato.getTrabajador().getNumDocumento()!= null){
				trazabilidadComprob.setIdTraba(dato.getTrabajador());
			}else {
				trazabilidadComprob.setIdTraba(trabajadorService.findByIdUserCliente_Username("Online"));
			}
			trazabilidadComprobantesService.registrar(trazabilidadComprob);
			System.out.println("Trazabilidad creado");
		}catch (Exception e) {
			System.out.println("Trazabilidad no creado" + e);
		}

		return new ResponseEntity<>(comprobantes.getIuc(),HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Comprobante> modificar( @RequestBody Comprobante dato) {
		return new ResponseEntity<Comprobante>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") String id) {
		Comprobante unaComprobante = service.listarxID(id);
		if(unaComprobante == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

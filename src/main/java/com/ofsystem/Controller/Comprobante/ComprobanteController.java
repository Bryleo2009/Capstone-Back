package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.CarritoFilter;
import com.ofsystem.Mapper.Filter.ComprobanteFilter;
import com.ofsystem.Model.*;
import com.ofsystem.Service.Imple.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Comprobante dato) {
		Comprobante unaComprobante = service.listarxID(dato.getIdComp());
		URI location = null;
		if(unaComprobante != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaComprobante.getIdComp()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdComp() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdComp()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	@PostMapping("/registrarXComprobanteFilter")
	public ResponseEntity<Object> registrarXComprobanteFilter( @RequestBody ComprobanteFilter dato) {

		System.out.println(dato);

		Comprobante comprobantes = new Comprobante();

		comprobantes.setNomClientComp(dato.getCliente().getNombre());
		comprobantes.setMontoSubtotalComp(dato.getMontoProducto());
		comprobantes.setMontoTotalComp(dato.getAmmount());
		comprobantes.setFechaEmiComp(new Date("02/05/2023"));
		comprobantes.setDireccionComp(dato.getDireccionComp());
		comprobantes.setUbigeoComp(dato.getUbigeoComp());
		comprobantes.setIdTp(tipoPagoService.listarxID(1));
		if(dato.isIdTc()){ //true = factura
			comprobantes.setIdTc(tipoComproService.listarxID(2));
		}else {
			comprobantes.setIdTc(tipoComproService.listarxID(1));
		}
		comprobantes.setIdUser(dato.getCliente().getIdUserCliente());

		service.registrar(comprobantes);
		System.out.println(comprobantes);
		Detalle detalles = new Detalle();

		detalles.setIdComp(comprobantes);

		for (CarritoFilter carritoFilter : dato.getCarritoFilterList()){

			int cantidad = carritoFilter.getCantProduct();
			detalles.setCantProductDetalle(cantidad);

			Producto producto = new Producto();

			producto = productoService.listarxID(carritoFilter.getIdProduct());

			detalles.setPrecioUniDetalle(producto.getPrecioUni());
			detalles.setPrecioTotalDetalle(producto.getPrecioUni() * cantidad);
			detalles.setProductoDetalle(producto.getDescripcionProduct());
			detalles.setIdProduct(producto.getIdProduct());
			detalles.setImagen(producto.getImagen());
			detalles.setPrecioDescuento(producto.getPrecioDescuProduct());

			detalleService.registrar(detalles);

		}

		TrazabilidadComprobantes trazabilidadComprob = new TrazabilidadComprobantes();

		trazabilidadComprob.setIdComp(comprobantes);
		trazabilidadComprob.setIdProceActual(estComproService.listarxID(1));
		trazabilidadComprob.setIdCliente(dato.getCliente());

		if(dato.getTrabajador()!= null){

			trazabilidadComprob.setIdTraba(dato.getTrabajador());

		}else {

			Trabajador trabajador = new Trabajador();
			Usuario usuario = new Usuario();

			usuario.setUsername("Online");
			usuario.setPassword("Online");
			usuario.setIdRol(rolService.listarxID(1));
			usuario.setEstadoUser(true);
			trabajador.setIdUserTrabajador(usuario);
			trabajador.setTrabajador(true);
			trabajador.setNombre("Online");
			trabajador.setApellido("Online");
			trabajador.setTelefono("Online");
			trabajador.setDireccion("Online");
			trabajador.setUbigueo("Online");
			trabajador.setNumDocumento("Online");

			trazabilidadComprob.setIdTraba(trabajador);
		}

		trazabilidadComprob.setObservac("Online");

		trazabilidadComprob.setFechaIniProc(new Date());

		trazabilidadComprobantesService.registrar(trazabilidadComprob);

		return new ResponseEntity<>(HttpStatus.OK);
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

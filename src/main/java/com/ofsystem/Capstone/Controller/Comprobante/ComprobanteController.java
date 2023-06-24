package com.ofsystem.Capstone.Controller.Comprobante;

import com.ofsystem.Capstone.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Capstone.Mapper.Filter.ComprobanteDFilter;
import com.ofsystem.Capstone.Mapper.Filter.ComprobanteFilter;
import com.ofsystem.Capstone.Mapper.Filter.ProductoFilter;
import com.ofsystem.Capstone.Mapper.Filter.ProductoStorage;
import com.ofsystem.Capstone.Model.Comprobante.ReportService;
import com.ofsystem.Capstone.Model.Producto.Producto;
import com.ofsystem.Capstone.Service.Imple.Comprobante.ComprobanteServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Comprobante.DetalleServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Comprobante.TrazabilidadComprobantesServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Enums.EstComproServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Enums.RolServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Enums.TipoComproServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Enums.TipoPagoServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Producto.ProductoServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Usuario.TrabajadorServiceImpl;
import com.ofsystem.Capstone.Model.Comprobante.Comprobante;
import com.ofsystem.Capstone.Model.Comprobante.Detalle;
import com.ofsystem.Capstone.Model.Comprobante.TrazabilidadComprobantes;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
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

	@GetMapping("/id/{id}")
	public ResponseEntity<Comprobante> listarPorId(@PathVariable("id") String id) {
		Comprobante unaComprobante = service.listarxID(id);
		if(unaComprobante == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<Comprobante>(unaComprobante,HttpStatus.OK);
	}

	@GetMapping("/comp/{idComp}")
	public ResponseEntity<List<ComprobanteDFilter>> listarComprobanteXID(@PathVariable("idComp") String idComp) {
		List<ComprobanteDFilter> unComprobante = service.ListarComprobanteXID(idComp);
		if (unComprobante == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + idComp);
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(unComprobante, headers, HttpStatus.OK);
	}


	@Autowired
	private ReportService services;

	@GetMapping("/{idComp}/report/{format}")
	public  String generateReport(@PathVariable String format, @PathVariable String idComp) throws FileNotFoundException, JRException {
		List<ComprobanteDFilter> unComprobante = service.ListarComprobanteXID(idComp);
		if (unComprobante == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + idComp);
		}
		return services.exportReport(format,idComp);
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
			for (ProductoFilter productoStorage : dato.getProductoStorageList()){
				int cantidad = productoStorage.getCantidad();
				detalle.setIdDetalle(detalleService.idDetalle() + 1);
				detalle.setCantProductDetalle(cantidad);
				Producto producto = productoService.listarxID(productoStorage.getProducto().getIdProduct());
				System.out.println(producto.getIUP());
				detalle.setPrecioUniDetalle(producto.getPrecioUni());
				detalle.setPrecioTotalDetalle(producto.getPrecioUni() * cantidad);
				detalle.setProductoDetalle(producto.getIUP()+" | "+producto.getNombreProduct());
				detalle.setPrecioDescuentoDetalle(producto.getPrecioDescuProduct());
				detalle.setIdProduct(producto);
				detalleService.registrar(detalle);
				System.out.println(detalle);
			}
			System.out.println("Detalle creado");
		}catch (Exception e) {
			System.out.println("Detalle no creado" + e);
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

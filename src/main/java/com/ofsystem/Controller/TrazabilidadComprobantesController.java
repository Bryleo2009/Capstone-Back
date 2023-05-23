package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.TrazabilidadComprobFilter;
import com.ofsystem.Model.*;
import com.ofsystem.Service.Imple.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/TrazabilidadComprobantess")
public class TrazabilidadComprobantesController {

	@Autowired
	private TrazabilidadComprobantesServiceImpl service;
	@Autowired
	private ClienteServiceImpl serviceCli;

	@Autowired
	private TrabajadorServiceImpl serviceTra;
	@Autowired
	private ComprobanteServiceImpl serviceComprob;
	@GetMapping
	public ResponseEntity<List<TrazabilidadComprobantes>> listar() {
		return new ResponseEntity<List<TrazabilidadComprobantes>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TrazabilidadComprobantes> listarPorId(@PathVariable("id") int id) {
		TrazabilidadComprobantes unaTrazabilidadComprobantes = service.listarxID(id);
		if(unaTrazabilidadComprobantes == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<TrazabilidadComprobantes>(unaTrazabilidadComprobantes,HttpStatus.OK);
	}
	
/*	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody TrazabilidadComprobantes dato) {
		TrazabilidadComprobantes unaTrazabilidadComprobantes = service.listarxID(dato.getIdTrazaCompro());
		URI location = null;
		if(unaTrazabilidadComprobantes != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaTrazabilidadComprobantes.getIdTrazaCompro()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdTrazaCompro() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdTrazaCompro()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}*/

	@PostMapping("/trazabilidad/comprobantes")
	public ResponseEntity<Object> RegistrarTrazabilidadComprob(@RequestBody List<TrazabilidadComprobFilter> dato) {
		List<TrazabilidadComprobantes> trazabilidadComprobantesList = new ArrayList<>();
		for (TrazabilidadComprobFilter trazabilidadComprobFilter : dato) {

			Comprobante idComp = trazabilidadComprobFilter.getIdComp();
			Cliente idCliente = trazabilidadComprobFilter.getIdCliente();
			Trabajador idTrabajador = trazabilidadComprobFilter.getIdTrabajador();
			String Observac = trazabilidadComprobFilter.getObservac();

			Comprobante unComprobante = serviceComprob.listarxID(idComp.getIdComp());
			Cliente unCliente = serviceCli.listarxID(idCliente.getId());
			Trabajador unTrabajador = serviceTra.listarxID(idTrabajador.getId());

			TrazabilidadComprobantes trazabilidadComprob = new TrazabilidadComprobantes();
			trazabilidadComprob.setIdComp(idComp);
			trazabilidadComprob.setIdCliente(idCliente);
			trazabilidadComprob.setIdTraba(idTrabajador);
			trazabilidadComprob.setObservac(Observac);

			trazabilidadComprob.setFechaIniProc(new Date()); // Asignar la fecha inicial actual
			trazabilidadComprob.setFechaFinProc(new Date());

			TrazabilidadComprobantes trazabilidadRegistrada = service.registrar(trazabilidadComprob);
			trazabilidadComprobantesList.add(trazabilidadRegistrada);

		}
		return ResponseEntity.ok(trazabilidadComprobantesList);
	}

	@PutMapping
	public ResponseEntity<TrazabilidadComprobantes> modificar( @RequestBody TrazabilidadComprobantes dato) {		
		return new ResponseEntity<TrazabilidadComprobantes>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		TrazabilidadComprobantes unaTrazabilidadComprobantes = service.listarxID(id);
		if(unaTrazabilidadComprobantes == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

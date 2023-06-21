package com.ofsystem.Capstone.Controller.Comprobante;

import com.ofsystem.Capstone.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Capstone.Model.Comprobante.Detalle;
import com.ofsystem.Capstone.Service.Imple.Comprobante.DetalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Detalles")
public class DetalleController {

	@Autowired
	private DetalleServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Detalle>> listar() {
		return new ResponseEntity<List<Detalle>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Detalle> listarPorId(@PathVariable("id") int id) {
		Detalle unaDetalle = service.listarxID(id);
		if(unaDetalle == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Detalle>(unaDetalle,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Detalle dato) {
		Detalle unaDetalle = service.listarxID(dato.getIdDetalle());
		URI location = null;
		if(unaDetalle != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaDetalle.getIdDetalle()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdDetalle() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdDetalle()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Detalle> modificar( @RequestBody Detalle dato) {		
		return new ResponseEntity<Detalle>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Detalle unaDetalle = service.listarxID(id);
		if(unaDetalle == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

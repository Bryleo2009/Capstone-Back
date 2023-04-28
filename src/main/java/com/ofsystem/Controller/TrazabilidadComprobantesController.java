package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.TrazabilidadComprobantes;
import com.ofsystem.Service.Imple.TrazabilidadComprobantesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/TrazabilidadComprobantess")
public class TrazabilidadComprobantesController {

	@Autowired
	private TrazabilidadComprobantesServiceImpl service;
	
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
	
	@PostMapping
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

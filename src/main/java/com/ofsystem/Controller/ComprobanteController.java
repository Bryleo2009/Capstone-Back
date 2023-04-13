package com.ofsystem.Controller;

import com.ofsystem.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Comprobante;
import com.ofsystem.Service.Imple.ComprobanteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Comprobantes")
public class ComprobanteController {

	@Autowired
	private ComprobanteServiceImpl service;
	
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
	public ResponseEntity<Object> registrar(@Valid @RequestBody Comprobante dato) {
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
	
	@PutMapping
	public ResponseEntity<Comprobante> modificar(@Valid @RequestBody Comprobante dato) {		
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
